学习笔记


**Hash表**
1. Hash函数
2. Hash冲突
>链表法（HashMap） ,再Hash，线性探测（ThreadLocal）


3. 扩容
4. 填充因子
5. 在Hash


**HashSet**


HashSet底层实现就是HashMap put时HashMap的value put了一个Object


**HashMap**


Map的key需要复写equals，检测的时候会先校验hashCode，如果有hash冲突那么会检测equals。捅中长度大于8才会变成红黑树
装载因子如果大于0.75那么会进行扩容，增大数组长度，再次hash散列