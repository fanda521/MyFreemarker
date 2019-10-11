<#--数字的运用-->
abs 绝对值：num:${num?abs}  float:${float?abs}  num2:${num2?abs}
c  该内建函数将 "计算机语言" 的数字转换成字符串:
num:${num?c} float:${float?c}  num2:${num2?c}
is_infinite:辨别数字是否是无限浮点数(根据IEEE 754)
num:${num?is_infinite?string} float:${float?is_infinite?string} num2:${num2?is_infinite?string}
is_nan:辨别数字是否是浮点数NaN(根据IEEE 754)
比如， 基于 someNumber 的值是否是 NaN， someNumber?is_nan 结果是 true 或 false，
当然， 如果该数不是浮点类型，那么将会返回 false。
num:${num?is_nan?string} float:${float?is_nan?string} num2:${num2?is_nan?string}
lower_abc:
将 1， 2， 3，等...，转换为字符串 "a"， "b"， "c"，等... 当到达 "z"时，
那么会继续转换成如 "aa"， "ab"，等... 这和电子表格应用程序(比如Excel或Calc)
的列标签有着相同的逻辑。数字的最小值是 1。 没有上限值。如果数字是 0 或更小或它不是整数，
那么模板处理将会中止并发生错误。
<#list 1..30 as n>${n?lower_abc} </#list>
round, floor, ceiling
使用确定的舍入法则，转换一个数字到整数：

round：返回最近的整数。 如果数字以.5结尾，那么它将进位(也就是向正无穷方向进位)

floor：返回数字的舍掉小数后的整数 (也就是向负无穷舍弃)

ceiling：返回数字小数进位后的整数 (也就是向正无穷进位)
<#assign testlist=[
0, 1, -1, 0.5, 1.5, -0.5,
-1.5, 0.25, -0.25, 1.75, -1.75]>
<#list testlist as result>
    ${result} ?floor=${result?floor} ?ceiling=${result?ceiling} ?round=${result?round}
</#list>
string:将一个数字转换成字符串。
有四种预定义的数字格式：computer， currency，number 和 percent。
这些格式的明确含义是本地化(国家)指定的， 受Java平台安装环境所控制，
而不是FreeMarker，除了 computer，用作和 c 内建函数是相同的格式。
可以这样来使用预定义的格式：
<#assign x=42>
${x}
${x?string}  <#-- the same as ${x} -->
${x?string.number}
${x?string.currency}
${x?string.percent}
${x?string.computer}
除了这三种预定义格式，还可以使用 Java 数字格式语法 中的任意数字格式：

<#assign x = 1.234>
${x?string["0"]}
${x?string["0.#"]}
${x?string["0.##"]}
${x?string["0.###"]}
${x?string["0.####"]}

${1?string["000.00"]}
${12.1?string["000.00"]}
${123.456?string["000.00"]}

${1.2?string["0"]}
${1.8?string["0"]}
${1.5?string["0"]} <-- 1.5, rounded towards even neighbor
${2.5?string["0"]} <-- 2.5, rounded towards even neighbor

${12345?string["0.##E0"]}
upper_abc:和 lower_abc 相同，
但是它转换成大写字母，比如 "A"， "B"， "C"，… ， "AA"， "AB"， 等..
<#list 1..30 as n>${n?upper_abc} </#list>
ends_with:返回是否这个字符串以参数中指定的子串结尾
${"ahead"?ends_with("head")?string}





