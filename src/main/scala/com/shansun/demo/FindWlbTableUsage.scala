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
 * 查找物流宝SQL运行
 * 
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-6-25
 */
object FindWlbTableUsage {
     
    def main(args: Array[String]): Unit = {
        find("wlb_order") 
    }
    
    def find(tabName: String) {
        val source = Source.fromURL("http://depend.csp.taobao.net:9999/depend/tddl/show.do?query1Value=2012-06-24&query1Type=1&day=2012-06-24&hour=14&query2Type=2&name=wlb&ip=&port=&query3Type=2&method=query&pageNo=1&pageSize=10000&sortType=execNum")
        val content = source.getLines.mkString
        
        val parser = Parser.createParser(content, "GBK") 
        
        val visitor = new HtmlPage(parser)
        
        parser.visitAllNodesWith(visitor)
        
        val nodes = visitor.getTables()(1).getChildren() 
        
        var tables = visitor.getTables()
        
        val filter = new TagNameFilter("tr")
        val rows = nodes.extractAllNodesThatMatch(filter, true)
        
        var count = 0
        
        rows.toNodeArray().foreach(row => {
            val cols = row.getChildren.toNodeArray.filter(_ match {
                case x: TableColumn => true
                case _ => false
            })
            
            if(cols.length != 0) {
	            def getText = (index: Int) => {cols(index).getFirstChild().getText().trim()}
	            
	            val sql = getText(0) 
	             
	            if(sql.contains(tabName)) {
	                count += 1
	                
	            	println(sql + "\n")
	            }
            }
        })
        
        println("Total: " + count)
    }
}