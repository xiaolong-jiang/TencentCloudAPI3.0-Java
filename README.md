API3.0-V3-Java 签名示例
使用方法：直接将文件拖到项目，在需要使用的地方引入头文件，只需要setConfig一次


●单脸视频人脸融合接入引导
1.账号开通白名单，若通过子账号测试，需子账号所属的主账号已加白名单
2.视频融合操作手册PDF:https://drive.weixin.qq.com/s?k=AJEAIQdfAAoFY1F9vX
3.对应语言SDK包：https://drive.weixin.qq.com/s?k=AJEAIQdfAAoQcucNhm，常用整合Java-SDK整合包：https://drive.weixin.qq.com/s?k=AJEAIQdfAAo1sglwOx
4.视频人脸融合对外联调说明文档：https://drive.weixin.qq.com/s?k=AJEAIQdfAAoFhGwVIX
多脸视频融合接入详细可对接售前、运营、商务等，此处暂只提供单脸视频融合示例

●关于视频素材版权问题
1.明星人物、品牌LOGO等涉及版权风险的素材,均需要提供版权证明
2.版权模板请点击下载人脸融合版权证明,盖章后上传电子照片
3.如因版权问题发生纠纷,腾讯云概不负责,并有权将您的侵权素材下线

●关于素材属性问题
1.视频素材视频限制不大于500M,时长不超过30s,分辨率不超过720p*1280p,不高于30fps
2.指定人脸图片总像素点不超过1920*1280,大小不超过1M,格式支持jpg或png,包含上述视频中出现的人物的单人照,并且正面、清晰、无遮挡

●关于接口耗时问题
1.据以往客户案例,基本上视频在20S左右,建议素材视频在15S左右为佳。视频越长用户体验效果越好,视频越短响应效率越高
2.(单脸)素材视频时长<15s,接口响应时长比例约为1:1,15S<素材视频时长<30s,接口响应时长比例约为2:1
3.目前多脸视频换脸最多支持两张脸换脸,双人脸素材耗时为单脸耗时的2倍时长
4.为提升处理效率,建议用2/3时间查询处理结果,如果首次查询不到,增加首次查询的一半
说明：第一次查询比较久，后面时间是递减的，比如第一次10s，第二次5s，越往后视频合成的可能性久越大，2/3是查询在总流程的大致耗时占比。如果要高实时性，建议提高查询频率
若耗时较长存在疑问，可以提供近期耗时较长请求的requestId或JobId给到我们协助排查

●关于时效问题
1.Submit接口生成的JobId的有效期：1小时
2.Query接口生成的VideoUrl（视频）的有效期：24小时

常见问题FAQ：

问1：图片传输用url还是base64，如果是url，存在哪里综合性能会更快，是否需要开网络加速功能等？
1.建议访问传url
2.如果资源在海外的话建议使用腾讯云cos作为存储：https://cloud.tencent.com/product/cos
3.我们返回的链接在国内，预估需要配合做一下cdn加速处理

问2：海外客户如何接入视频人脸融合
1）选择就近接入域名（如：）访问视频融合服务；
2）客户的应用端通过服务端访问腾讯云视频融合服务，服务端调用腾讯云服务HTTP客户端最好设置头字段X-Forwarded-For为应用端IP
3）调用API图片最好使用url，图片有客户端上传到oss或者cos，这里推荐使用腾讯云COS
4）submit以及query接口调用的规则，建议query时，在submit后等待视频时长-3～5s作为首次查询时间，后续可以按照每等待1s查询1次，大概率首次就能拿到结果
5）对于返回视频地址
策略一：优先考虑全球加速地址，suppose我们返回url域名：videofacefusion-prod-1254418846.cos.ap-guangzhou.myqcloud.com，在server端将地址域名修正成：videofacefusion-prod-1254418846.cos.accelerate.myqcloud.com
策略二：如客户的用户在客户端仍反馈下载失败率高，可以将地址域名修改成cdn加速域名，videofacefusion-prod-1254418846.file.myqcloud.com，
● 注意：策略二本身只是保证合成下载的成功率，客户端下载时长会增长，COS全球加速有可能在有些国家和地区没有效果，因此需要策略2打底

问3：视频人脸融合出现人脸出框或者配准失败等问题，怎么避免？
1.调用腾讯云人脸识别-人脸检测接口，https://cloud.tencent.com/document/product/867/44989，打开人脸质量检测开关，NeedQualityDetection = 1
2.对返回内容做判断，FaceInfos中目标人脸做人脸90关键点在人脸框内，人脸质量分>=70
详细参考：https://drive.weixin.qq.com/s?k=AJEAIQdfAAoMS9tvcT

问4：最大支持融合几张脸？
产品对外支持2张脸，目前算法能力上验证了4张脸，如果需要支持大于2张脸，与产品联系

问5：控台上传素材在页面后未点击确定，时间间隔在1-2分钟，后续一直没审核通过
那可能得半个小时后了，不点击确定代表素材没有创建成功，自动审核上传完视频后就开始审核了，回调一般在10s之内，这时候素材没有创建成功，就无法更新状态，一般会做快速重试；如果不成功，半个小时后才会做再次重试

问6：视频融合后视频出波纹，类似摩尔纹样式
将用户上传的素材，直接改成逐行显示： ffmpeg -i 修改后.mp4 -vf 'yadif=parity=auto' -vcodec libx264 tt2.mp4  基本ffmpeg处理后视频没有问题

问7：视频融合、驱动后视频出现绿边
产生原因：调整输入图分辨率，一般编/解码器都有16位对齐的处理（也存在32位、64位对齐的），主要原因是缓冲分辨率比视频分辨率多出一点宏块，导致产生绿边问题
解决方案：
1.编解码时保证16位对齐
2.解码时遇到非16位对齐的分辨率，解码器一般会解码成比较接近的更大的尺寸（有可能长宽均有变化），因此需要手动做裁剪

问8：腾讯云视频融合控台页面上传素材上传失败，内部错误等
1.清除高级缓存重试
2.重试后无变化请联系我们

问9：视频融合业务比较典型的合作案例，比如faceplay外还有哪些？
参考：https://doc.weixin.qq.com/doc/w2_ABYA-waDACcF2rEVTbYSWKJllb4MY?scode=AJEAIQdfAAoWkG1GrqAEwANgaTACk

问10：人脸融合、人脸驱动支持对带通道图片进行处理吗?最终生成带通道,或者带mask信息的视频
不支持，我们输出的是mp4(H264+AAC)  
注：实际为算法支持，编解码侧不支持