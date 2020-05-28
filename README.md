### 使用说明

#### 执行方式
直接执行java.demo.test包下的测试类的main方法即可测试

目前仅支持开票，查询票据状态，OCR识别接口的测试类
其他接口测试，需要自行在BuildParam.java构建参数，在URLConfigEnum.java下配置url

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
