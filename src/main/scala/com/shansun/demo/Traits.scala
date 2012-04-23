package com.shansun.demo

/**
 * traits - require self type
 * @author:     lanbo <br>
 * @version:    1.0  <br>
 * @date:   	2012-4-22
 */
object Traits {

    class Trade(refNo: String, account: String, instrument: String, quantity: Int, unitPrice: Int) {
        //principal valueof the trade
        def principal = quantity * unitPrice
    }
    
    class AnotherTrade(percentage: Double)

    class NotTrade(principal: Int)

    trait Tax {
        // 要求Tax必须被Trade mixin
        self: Trade =>
        def calculateTax = principal * .2
    }

    trait Commission {
        // 要求Commission必须被Trade mixin
        self: Trade =>
        def calculateCommission = principal * .15
    }

    def main(args: Array[String]): Unit = {
        val trade = new Trade("demoNo", "demoAcct", "demoInst", 10, 20) with Tax with Commission
        println(trade.calculateTax)

        /*
         * illegal inheritance; 
         * self-type com.shansun.event.demo.Traits.NotTrade with com.shansun.event.demo.Traits.Tax does not 
         * conform to com.shansun.event.demo.Traits.Tax's selftype
         */
        // val notTrade = new NotTrade with Tax
    }

}