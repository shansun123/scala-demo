package com.shansun.demo

import scala.io.Source
import scala.xml.XML
import scala.xml.parsing.XhtmlParser
import org.htmlparser.Parser
import org.htmlparser.nodes.TextNode
import org.htmlparser.visitors.HtmlPage
import org.htmlparser.tags.TableTag
import org.htmlparser.tags.TableRow
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TagName
import org.htmlparser.filters.TagNameFilter
import org.htmlparser.tags.TableColumn
import java.util.Date
import java.text.SimpleDateFormat
import org.squeryl.KeyedEntity
import org.squeryl.Schema

/**
 * 查找西花庭成交记录
 * 
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-5-10
 */
object FindXihuatingDeal {
    
    var currentSize = 0
    var currentArv = 0

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
            val sold = getText(3).toInt
            val price = getText(4).toInt
            
            if(name.startsWith("西花庭")) {
                if(sold != currentSize) {
                    printf("%s: Sold(%s), Arverage(%s), Last(%d, %d)\n", dateStr, sold, price, currentSize, currentArv)
                    
                    currentSize = sold
                    currentArv = price
                }
            }
        })
    }
    
    class BaseEntity extends KeyedEntity[Long] {
        val id: Long = 0
        val gmtCreate = new Date
        val gmtModified = new Date
    }
    
    class Deal(val estate: String,
               val sold: Long,
               val preSold: Long,
               val arverage: Long,
               val lastAverage: Long,
               val totalSold: Long,
               val totalPreSold: Long) 
          extends BaseEntity
    
    object Scheme extends Schema {
        
        val deals = table[Deal]
        
        on(deals)(deal => declare(
//	      deal.id is (autoIncremented)
	    ))
        
    }
}