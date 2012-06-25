package com.shansun.demo
import java.io.File
import scala.io.Source
import scala.io.Codec

/**
 * 检查XML文件编码是否正确
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-17
 */
object XmlFileEncodingChecker {

    val pattern = "encoding=\"(\\w+)\"".r

    def check(file: File) {
        println(file.listFiles.mkString("\n"))

        if (file == null) null

        else for (f <- file.listFiles() if !(f.getName() equals ".svn") && (f.isDirectory() || f.getName().endsWith(".xml"))) {
            if (f.isDirectory()) {
                check(f)
            } else try {
                val list = Source.fromFile(f).getLines.toList
                if (list.isEmpty) return

                val res = pattern findFirstIn list(0) mkString

                if (res != "")
                    res.substring(10, res.length() - 1).toUpperCase() match {
                        case "GBK" =>
                        case encoding => println(f.getName + ": " + encoding)
                    }
            } catch {
                case _ => println(Source.fromFile(f))
            }

        }
    }

    def main(args: Array[String]): Unit = {
        //implicit val codec = Codec("UTF-8")
        //       check(new File(args(0)))
        check(new File("""D:\tb-ws\trunk\inventoryplatform\ip-server\"""))
        //println(Source.fromFile("""D:\tb-ws\trunk\inventoryplatform\ip-server\src\main\resources\dbconfig\sqlmap\ipm_inventory_SqlMap.xml""").getLines.mkString)
    }
}