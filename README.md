### 使用说明

#### 执行方式
直接执行java.demo.test包下的测试类的main方法即可测试

#### 切换环境
切换环境测试需要修改URLConfigEnum.java的参数 KEY_PATH PASSWORD APPID DOMAIN

#### 包含义
- crypto 放置密钥相关的处理类
- entity 放置参数构建类
- test 放置接口测试的入口类
- utils 放置请求相关的工具类

#### 证书
- resources/certificate/pro22.pfx

#### API文档
- resources/certificate/电子发票OpenAPI文档V1.24.html
- resources\certificate\全票种-直接对接台账（ocr方式，不通过个人票夹）.pdf

##说明
####BuildParam.java放置电子发票参数
- buildInsertWithArrayPostParam() 构造开票蓝票请求服务 表单数据
- issue() 开票申请审核通过
- red() 发票红冲请求服务及电子发票部分红冲
- insertWithSplit()   开票蓝票请求服务--发票拆分
- buildUrlConfigs()  url回掉配置
- buildSmsConfigs()  构造短信发送信息
- buildRequestDatas() 构造requestdatas
-  redRequestDatas()  构造redRequestdatas
- buildRequestDatasSplit()  构造蓝票请求服务--发票拆分数据
-  buildItems() 构造request发票明细
- buildFpqqlsh() 获取发票请求流水号
长度不超过20位，长度在1到20位的字母和数字组合，不可以重复的，
不要包含window系统文件名限制的特殊字符


####StaBookBuildParam.java放置全票种参数
- buildRecognisePostParam()  OCR识别
-  OCR_Save() 识别结果保存台帐
- OCR_SaveBills() 保存报销票据明细
- OCR_SaveMachineData() 机打发票data
- OCR_SaveAirData() 航空电子行程单DATA
- itemList() 航空电子行程单DATA里面itemList参数设置
- OCR_SaveTrainData() 火车票台账data
- OCR_SaveTaxiData() 出租车保存报销data
- reimbursed() 台账报销
-  reimbursedBills() 台账报销Bills参数设置
- cancelReimbursed() 台账取消报销
- account() 台账记账
- accountBills()台账记账Bills
- cancelAccount() 台账取消记账
- delete() 报销台账删除
- find()   飞机票、火车票，出租车台账查询
- commit() 个人票夹提交发票到报销台账_全票种
- summary() 个人票夹提交发票到报销台账_全票种中summary参数设置
