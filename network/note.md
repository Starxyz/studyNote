### win10 使用netsh开启wifi热点

1. netsh wlan set hostednetwork mode=allow ssid=my_wifi key=wifi123456
2. netsh wlan start hostednetwork

通过这两个命令即可开启win10 的wifi热点，key是密码。start hostednetwork会在网络中心产生一个windows虚拟网卡（本地连接*12），下一步就是允许主机网络共享给刚刚创建的虚拟网卡。至此，连接该热点的设备就可以上网了

stop hostednetwork关闭热点



