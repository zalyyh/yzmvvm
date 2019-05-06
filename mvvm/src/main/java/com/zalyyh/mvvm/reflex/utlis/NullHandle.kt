package com.zalyyh.mvvm.reflex.utlis

/**
 * ————————————————————————————————
 * 对 null 对象的处理
 * 初期想法有待完善
 *  1。对于空字符串转换成 ""
 *  2。对于空对象  暂未想好怎么处理
 * Date: 2019/5/5 2:38 PM
 * ————————————————————————————————
 */
class NullHandle {
    companion object{
        fun  handleString(str:String?):String{
            var str = str;
            if (str == null)
                str = "";
            return str;
        }
    }

}