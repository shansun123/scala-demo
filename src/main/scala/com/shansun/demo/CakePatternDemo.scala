package com.shansun.demo

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-16
 */
object CakePatternDemo {

    sealed case class User(userName: String)

    trait UserRepositoryComponent {
        def userRepository: UserRepository

        trait UserRepository {
            def find(userName: String): User
        }
    }

    trait UserRepositoryComponentHibernateImpl extends UserRepositoryComponent {
        def userRepository = new UserRepositoryImpl

        class UserRepositoryImpl extends UserRepository {
            def find(userName: String): User = {
                println("Find with hibernate: " + userName)
                new User(userName)
            }
        }
    }

    trait UserAuthorizationComponent {
        def userAuthorization: UserAuthorization

        trait UserAuthorization {
            def authorize(user: User)
        }
    }

    trait UserAuthorizationComponentImpl extends UserAuthorizationComponent {
        this: UserRepositoryComponent =>

        def userAuthorization = new UserAuthorizationImpl

        class UserAuthorizationImpl extends UserAuthorization {
            def authorize(user: User) {
                println("Authrizing " + user.userName)

                userRepository.find(user.userName)
            }
        }
    }

    def main(args: Array[String]): Unit = {
        val env = new UserAuthorizationComponentImpl with UserRepositoryComponentHibernateImpl

        env.userAuthorization.authorize(User("lanbo"))

        val envTesting = new UserAuthorizationComponentImpl with UserRepositoryComponent {
            def userRepository = mock(classOf[UserRepository])

            println(classOf[UserRepository])

            def mock[T <: AnyRef](obj: T): UserRepository = {
                new MockUserRepository
            }

            class MockUserRepository extends UserRepository {
                def find(userName: String): User = {
                    println("Find with mock: " + userName)
                    new User(userName)
                }
            }
        }

        envTesting.userAuthorization.authorize(User("Xujun"))
    }

}