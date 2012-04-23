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
        println("/n1. ���� ZooKeeper �ڵ� (znode �� zoo2, ���ݣ� myData2 ��Ȩ�ޣ� OPEN_ACL_UNSAFE ���ڵ����ͣ� Persistent")

        zk.create("/zoo2", "myData2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT)

        println("/n2. �鿴�Ƿ񴴽��ɹ���")

        println(new String(zk.getData("/zoo2", false, null)))

        println("/n3. �޸Ľڵ����� ")

        zk.setData("/zoo2", "shenlan211314".getBytes(), -1);

        println("/n4. �鿴�Ƿ��޸ĳɹ��� ")

        println(new String(zk.getData("/zoo2", false, null)))

        println("/n5. ɾ���ڵ� ")

        zk.delete("/zoo2", -1)

        println("/n6. �鿴�ڵ��Ƿ�ɾ���� ")

        println(" �ڵ�״̬�� [" + zk.exists("/zoo2", false) + "]")
    }

    def zkClose = zk.close()

    def main(args: Array[String]) {
    	zkOptions
    	
    	zkClose
    }
}