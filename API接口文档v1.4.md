#API接口文档
##用户登录注册
###登录
>http请求方式：POST
>接口地址：https://xxx.xxx.xxx:8080/login

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uname|用户名|是|
|pwd|密码|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码 “0”：登录成功 “1” 用户名或密码为空 “2”：用户名或密码错误|
|uid|返回用户ID|

登录成功返回JSON数据包：
```
{
	 "ErrorCode":0,
	"uid":"用户名"
	}
```
用户名或密码为空返回JSON数据包：
```
{ 
"ErrorCode":1, 
"uid":"用户名" 
} 
```
用户名或密码错误返回JSON数据包：
```
{ 
"ErrorCode":2, 
"uid":"用户名" 
} 
```
###注册
>http请求方式：POST
>接口地址：https://xxx.xxx.xxx:8080/signup


参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uname|名字|是|
|pwd|密码|是|
|telephone|手机号|否|
|email|邮箱|否|
|birthday|生日|否|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码 “0”：注册成功。“1”：注册失败|
|uid|用户ID|

注册成功返回JSON
```
{
"ErrorCode":1,
"uid":"用户ID"
}
```
注册失败返回JSON
```
{
"ErrorCode":1,
"uid":用户ID
}
```

###用户信息
>http请求方式：GET
>接口地址:https://xxx.xxx.xxx:8080/information


参数
|字段|说明|是否必填|
|:--|:--|:--|
|uname|用户名|是|
|email|邮箱|否|
|telephone|手机号|否|
|uid|用户id|是|

返回结果
|参数|说明|
|:--|:--|
|ErrorCode|状态码"0:"成功。"1":失败|
|uid|用户id|
|uname|用户名|
|telephone|手机号|
|email|邮箱|
|birthday|生日|
|MessageCode|是否有新消息|

查看用户信息成功：
```
{
	"ErrorCode":"0",
	"uid":"用户id",
	"uname":"用户名",
	"telephone":"手机号",
	"email":"邮箱",
	"birthday":"生日",
	"MessageCode":"是否有新消息"
}
```
查看用户信息失败：
```
{
	"ErrorCode":"1",
}
```
##情书卡片
###用户情书卡片查询
>http请求方式:get
>接口地址：https://xxx.xxx.xxx:8080/userCardQuery


参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uid|用户id|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码，“0”：查询成功，“1”：找不到该用户|
|LoveLetterId|情书卡片ID|
|CardTitle|卡片标题|

查询成功：
```
{
	"ErrorCode":"0",
	"LoveLetterId":"情书卡片ID",
	"CardTitle":"卡片标题"
}
```
查询失败：
```
{
	"ErrorCode":"1"
}
```
###情书卡片查询
>http查询方法：get
>接口地址：https://xxx.xxx.xxx:8080/loveLetterQuery
参数：
|字段|说明|是否必填|
|:--|:--|:--|
|loveletterid|卡片ID|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码“0”：查询成功，“1”：找不到该卡片|
|card|卡片类|
|CardDecoration|卡片装饰类|

卡片类：
|参数|说明|
|:--|:--|
|CardTitle|卡片标题|
|CardBody|卡片正文|

卡片装饰类：
|参数|说明|
|:--|:--|
|CardType|类型（图片，形状）|
|CardLocation|位置：vector2|
|CardZoom|缩放：vector2|
|CardRevolve|旋转：float|

查询成功：
```
{
	"ErrorCode":"0",
	"card":[{
		"CardTitle":"卡片标题",
		"CardBody":"卡片正文"，
	}]
	"CardDecoration":[{
		"CardType":"类型（图片，形状）",
		"CardLocation":"位置"，
		"CardZoom":"缩放",
		"CardRevolve":"旋转"
	}]
}
```
查询失败：

```
{
	"ErrorCode":"1",
}
```
##消息
###用户收/发信箱查询
>http查询方法： get
>接口地址：https://xxx.xxx.xxx:8080/mailboxQuery

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uid|用户id|是|
|utype|操作类型（收/发）|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码,"0":查询成功，"1":查询失败|
|message|消息类|

消息类：
|参数|说明|
|:--|:--|
|MessageId|消息id|
|MessageType|消息类型（情书/文本）|
|MessageBody|情书id/消息正文|
|MessageTime|发送时间|
|SenderId|发送人id|
|ReadCode|是否已读|

查询成功：
```
{
	"ErrorCode":"0",
	"message":[
		{
			"MessageId":"消息id",
			"MessageType":"消息类型（情书/文本）",
			"MessageBody":"情书id/消息正文",
			"MessageTime":"发送时间"，
			"SenderId"："发送人id"，
			"ReadCode":"是否已读"，
		}
		]
}
```

查询失败：
```
{
	"ErrorCode":"1"
}
```
###发送消息
>http查询方法： post
>接口地址：https://xxx.xxx.xxx:8080/sendMessage

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uid|用户id|是|
|message|消息类|是|
|MessageTime|发送时间|是|

返回结果
|参数|说明|
|:--|:--|
|ErrorCode|状态码"0":发送成功。"1":发送失败|
|MessageId|消息ID|

发送成功：
```
{
	"ErrorCode":"0",
	"MessageId":"消息ID"
}
```
发送失败：
```
{
	"ErrorCode":"1",
	"MessageId":"消息ID"
}
```

###删除消息
>http查询方法： post
>接口地址：https://xxx.xxx.xxx:8080/deleteMessage

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uid|用户ID|是|
|MessageId|消息id|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码 "0":删除成功。"1":删除失败|

删除成功：
```
{
	"ErrorCode":"0",
}
```
删除失败：
```
{
	"ErrorCode":"1",
}
```

##日程
###日程查询
>http查询方法： get
>接口地址：https://xxx.xxx.xxx:8080/dateQueryWithPriod

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uid|用户id|是|
|LeftTime|时间左区间|是|
|RightTime|时间右区间|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|返回信息 “0”：查询成功 “1”：查询失败|
|date|日程类|

日程类：
|参数|说明|
|:--|:--|
|DateId|日程ID|
|StartTime|开始时间|
|EndTime|结束时间|
|MainBody|正文|
|DateType|类型（公开/私密）|
|AddId|添加人ID|

查询成功：
```
{
	"ErrorCode":0,
	"date":[
		{
		"DateId":"日程id",
		"StartTime":"开始时间",
		"EndTime":"结束时间",
		"MainBody":"正文",
		"DateType":"类型（公开/私密）",
		"AddId":"添加人id"
	}
]
}
```
查询失败：
```
{
    "ErrorCode":1,
}
```

###添加日程
>http查询方法： post
>接口地址：https://xxx.xxx.xxx:8080/adddate
参数：
|字段|说明|是否必填|
|:--|:--|:--|
|uid|用户ID|是|
|date|日程类|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|返回信息。“0”：添加成功。“1”：添加失败|
|DateId|日程ID|

添加日程成功：
```
{
"ErrorCode":"0",
"DateId":"日程ID"
}
```
添加日程失败：
```
{
"ErrorCode":"1",
"DateId":"日程ID"
}
```
###修改日程
>http查询方法： post
>接口地址：https://xxx.xxx.xxx:8080/modifydate

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|DateId|日程ID|是|
|date|日程类|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码"0":修改成功"1":修改失败|
|DateId|日程ID|

修改成功：
```
{
	"ErrorCode":0,
	"date":[
		{
		"DateId":"日程id",
		"StartTime":"开始时间",
		"EndTime":"结束时间",
		"MainBody":"正文",
		"DateType":"类型（公开/私密）",
		"AddId":"添加人id"
	}
]
}
```
修改失败：
```
{
    "ErrorCode":1,
   "date":[
		{
		"DateId":"日程id",
		"StartTime":"开始时间",
		"EndTime":"结束时间",
		"MainBody":"正文",
		"DateType":"类型（公开/私密）",
		"AddId":"添加人id"
    }
]
}
```


###删除日程
>http查询方法： post
>接口地址：https://xxx.xxx.xxx:8080/deletedate

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|DateId|日程id|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|状态码 "0":删除成功。"1"：删除失败|

删除成功：
```
{
	"ErrorCode":"0"
}
```
删除失败：
```
{
	"ErrorCode":"1"
}
```
###查询日程
>http查询方法： post
>接口地址：https://xxx.xxx.xxx:8080/dateQueryWithID

参数：
|字段|说明|是否必填|
|:--|:--|:--|
|dateid|日程ID|是|

返回结果：
|参数|说明|
|:--|:--|
|ErrorCode|返回信息 “0”：查询成功.“1”：找不到该日程|
|date|日程类|

查询成功：
```
{
	"ErrorCode":0,
	"date":[
		{
		"DateId":"日程id",
		"StartTime":"开始时间",
		"EndTime":"结束时间",
		"MainBody":"正文",
		"DateType":"类型（公开/私密）",
		"AddId":"添加人id"
	}
]
}
```
查询失败：
```
{
    "ErrorCode":1,
}
```

