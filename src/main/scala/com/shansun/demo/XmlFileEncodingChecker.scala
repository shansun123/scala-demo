package com.shansun.demo
import java.io.File
import scala.io.Source

/**
 * 检查XML文件编码是否正确
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-17
 */
object XmlFileEncodingChecker {

    val pattern = "encoding=\"(\\w+)\"".r

    def check(file: File) {
        if (file == null) null

        else for (f <- file.listFiles() if f.isDirectory() || f.getName().endsWith(".xml")) {
            if (f.isDirectory()) {
                check(f)
            } else {
                val list = Source.fromFile(f).getLines.toList
                if (list.isEmpty) return

                val res = pattern findFirstIn list(0) mkString

                if (res != "")
                    res.substring(10, res.length() - 1).toUpperCase() match {
                        case "GBK" =>
                        case encoding => println(f.getName + ": " + encoding)
                    }
            }
        }
    }

    def main(args: Array[String]): Unit = {
        //       check(new File(args(0)))
        check(new File("""D:\tb-ws\trunk\inventoryplatform\ip-server"""))
    }
}