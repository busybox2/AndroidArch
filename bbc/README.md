
## Fix&Bug
1. Dialog获取不到是否显示显示的状态，无法监听状态
2. 在定义了指定接收类型后，后台返回不同类型会崩溃（增加json容错机制：https://gitee.com/getActivity/GsonFactory）
3. 没有基础的统一ui，可借鉴或使用xui，并且把xui app给ui看看借鉴统一设计（xui｜qmui，投票，源码更改）
4. 网络框架冗余 （业务层直接请求到RemoteDataService)
5. 工具重复（log，toast，image等，增加文档培训）
6. 可增加mvvm基础控件(多增加databing)
7. 没有api说明文档（完善框架文档，重点）
8. 针对拍照及相册选择图片工具进行封装
9. 倒计时工具 CountDownTaskUtils 有出现倒计时在界面停止倒计时的情况，目前未测试出原因。（子线程回调，长时间使用问题）,TimerTaskUtils崩溃问题，停止运行
10. OkGo增加JsonCallback
11. 增加LiveEvenBus
12. 完善框架文档
13. CountDownTaskUtils、TimerTaskUtils工具优化
14. 网络框架优化

## Fix
### CountDownTaskUtils、TimerTaskUtils工具优化
- 一次任务
- 重复任务
- 定点任务
    - 每分钟执行
    - 每小时执行
    - 每天执行
    - 每月执行
    - 定时执行