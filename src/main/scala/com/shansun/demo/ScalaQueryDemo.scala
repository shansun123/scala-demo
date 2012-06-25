package com.shansun.demo
import org.scalaquery.session._
import org.scalaquery.session.Database.threadLocalSession
import org.scalaquery.ql._
import org.scalaquery.ql.TypeMapper._
import org.scalaquery.ql.extended.H2Driver.Implicit._
import org.scalaquery.ql.extended.{ExtendedTable => Table}
import org.scalaquery.session.Database 
import java.sql.Date

/**
 * <p></p>
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-28
 */
object ScalaQueryDemo {

    val db = Database.forURL("jdbc:mysql://10.232.31.158:3306/tmall_auction_00", driver = "com.mysql.jdbc.Driver", user="tmall_auction", password="tmall_auction")
     
    val TimeoutTasks = new Table[(Long, Int, Long, Int, Long, Date, Int, Int, Date, Date)]("ipm_timeout_task_00") {
        def id = column[Long]("id", O.PrimaryKey)
        def tgtType = column[Int]("tgt_type")
        def tgtId = column[Long]("tgt_id")
        def tgtIndex = column[Int]("tgt_index")
        def bizId = column[Long]("biz_id")
        def timeout = column[Date]("timeout")
        def status = column[Int]("status")
        def modNum = column[Int]("mod_num")
        def gmtCreate = column[Date]("gmt_create")
        def gmtModified = column[Date]("gmt_modified")
        
        // Every table needs a * projection with the same type as the table's type parameter
        def * = id ~ tgtType ~ tgtId ~ tgtIndex ~ bizId ~ timeout ~ status ~ modNum ~ gmtCreate ~ gmtCreate
    } 
    
    def main(args: Array[String]): Unit = {
        
        db withSession { 
            val d = new Date(System.currentTimeMillis())
            TimeoutTasks.insert(1L, 1, 123L, 1, 12345L, d, 0, 10, d, d)
        }
    }

}