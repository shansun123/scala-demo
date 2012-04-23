package com.shansun.demo

import org.apache.zookeeper.{ Watcher, WatchedEvent, ZooKeeper, CreateMode }
import org.apache.zookeeper.ZooDefs.Ids

/**
 * ZooKeeper
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-6
 */
object ZooKeeperDemo {
    val SESSION_TIMEOUT = 30000

    val wh = new Watcher() {
        def process(event: WatchedEvent) = println(event.toString())
    }

    val zk = new ZooKeeper("10.232.37.114:2181", SESSION_TIMEOUT, wh)
    
    Thread.sleep(3000)

    def zkOptions(): Unit = {
        println("/n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限： OPEN_ACL_UNSAFE ，节点类型： Persistent")

        zk.create("/zoo2", "myData2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)

        println("/n2. 查看是否创建成功：")

        println(new String(zk.getData("/zoo2", false, null)))

        println("/n3. 修改节点数据 ")

        zk.setData("/zoo2", "shenlan211314".getBytes(), -1);

        println("/n4. 查看是否修改成功： ")

        println(new String(zk.getData("/zoo2", false, null)))

        println("/n5. 删除节点 ")

        zk.delete("/zoo2", -1)

        println("/n6. 查看节点是否被删除： ")

        println(" 节点状态： [" + zk.exists("/zoo2", false) + "]")
    }

    def zkClose = zk.close()

    def main(args: Array[String]) {
    	zkOptions
    	
    	zkClose
    }
}