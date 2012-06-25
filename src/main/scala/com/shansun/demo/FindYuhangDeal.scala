package com.shansun.demo
import org.htmlparser.filters.TagNameFilter
import org.htmlparser.visitors.HtmlPage
import scala.io.Source
import org.htmlparser.Parser
import java.util.Date
import org.htmlparser.tags.TableColumn
import scala.collection.mutable.Map
import java.text.SimpleDateFormat

/** 
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-5-10
 */
object FindYuhangDeal {
    val houseTable = Map[String, (Int, Int, Int)]()

    def main(args: Array[String]): Unit = {
        while(true) {
            find
            Thread.sleep(60000)
        }    
    }
    
    def find() {
        val source = Source.fromURL("http://www.yhfc.gov.cn/index.html")
        val content = source.getLines.mkString
        
        val parser = Parser.createParser(content, "GBK") 
        
        val visitor = new HtmlPage(parser)
        
        parser.visitAllNodesWith(visitor)
        
        val nodes = visitor.getTables()(7).getChildren() 
        
        val filter = new TagNameFilter("tr")
        val rows = nodes.extractAllNodesThatMatch(filter, true)
        
        val date = new Date()
        val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val dateStr = format.format(date)
        
        rows.toNodeArray().foreach(row => {
            val cols = row.getChildren.toNodeArray.filter(_ match {
                case x: TableColumn => true
                case _ => false
            })
            
            def getText = (index: Int) => {cols(index).getFirstChild().getText().trim()}
            
            val name = getText(0)
            val presold = getText(2).toInt
            val sold = getText(3).toInt
            val price = getText(4).toInt
            
            if(houseTable.get(name) != None) {
                val value = houseTable.get(name).get
                if(value._1 != presold || value._2 != sold) {
                    printf("%s  %s: Pre-Sold(%d), Sold(%d), Arverage(%d), Last(%d, %d, %d)\n", dateStr, name, presold, sold, price, value._1, value._2, value._3)
                    houseTable(name) = (presold, sold, price)
                }
            } else {
                printf("%s  %s: Pre-Sold(%d), Sold(%d), Arverage(%d), Last(%d, %d, %d)\n", dateStr, name, presold, sold, price, 0, 0, 0)
                houseTable(name) = (presold, sold, price)
            }
        })
    }
}