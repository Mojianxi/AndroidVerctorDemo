# 新手Android SVG矢量图动画进阶

###### Android中svg实现的svg动画效果(超简单,在Android中除svg路径动画外，svg已经兼容到3.0以下,源代码已上传github)

![5c85d82099906](https://i.loli.net/2019/03/11/5c85d82099906.gif)![5c85d82099906](https://i.loli.net/2019/03/11/5c85d82099906.gif)

## 什么是SVG

#### svg概念

- SVG 指可伸缩矢量图形 (Scalable Vector Graphics)

- SVG 用来定义用于网络的基于矢量的图形

- SVG 使用 XML 格式定义图形

- SVG 图像在放大或改变尺寸的情况下其图形质量不会有所损失

- SVG 是万维网联盟的标准

- SVG 与诸如 DOM 和 XSL 之类的 W3C 标准是一个整体

#### svg历史和优势

- SVG 于 2003 年 1 月 14 日成为 W3C 推荐标准。

- SVG 可被非常多的工具读取和修改（比如记事本）

- SVG 与 JPEG 和 GIF 图像比起来，尺寸更小，且可压缩性更强。

- SVG 是可伸缩的

- SVG 图像可在任何的分辨率下被高质量地打印

- SVG 可在图像质量不下降的情况下被放大

- SVG 图像中的文本是可选的，同时也是可搜索的（很适合制作地图）

- SVG 可以与 Java 技术一起运行

- SVG 是开放的标准

- SVG 文件是纯粹的 XML

#### SVG工具和获取SVG资源

- [svg在线编辑器1](https://editor.method.ac/)

  ![5c85d24c1967c](https://i.loli.net/2019/03/11/5c85d24c1967c.png)![5c85d24c1967c](https://i.loli.net/2019/03/11/5c85d24c1967c.png)

- [svg在线编辑器2](https://www.zhangxinxu.com/sp/svg/)

  ![5c85d2733e082](https://i.loli.net/2019/03/11/5c85d2733e082.png)![5c85d2733e082](https://i.loli.net/2019/03/11/5c85d2733e082.png)

- [svg在线编辑预览工具](http://www.bejson.com/ui/svg_editor/)

  ![5c85d6018522a](https://i.loli.net/2019/03/11/5c85d6018522a.png)![5c85d6018522a](https://i.loli.net/2019/03/11/5c85d6018522a.png)

- 阿里巴巴的iconfont图标网站可以下载svg格式图片

  ![5c85d611a9845](https://i.loli.net/2019/03/11/5c85d611a9845.png)![5c85d611a9845](https://i.loli.net/2019/03/11/5c85d611a9845.png)

- 各种设计工具也支持svg格式图片的导出

#### 在html中定义一个简单的svg

- 代码

- ![预览](http://www.w3school.com.cn/svg/circle1.svg)![预览](http://www.w3school.com.cn/svg/circle1.svg)

## Android中如何使用SVG

###### 在Android中通过Vector来定义svg,vector对svg语法进行了简化，主要通过path来画出图形轨迹[详情参考](https://www.jianshu.com/p/e3614e7abc03)

1. 支持指令

   - M = moveto(M X,Y) ：将画笔移动到指定的坐标位置

   - L = lineto(L X,Y) ：画直线到指定的坐标位置

   - H = horizontal lineto(H X)：画水平线到指定的X坐标位置

   - V = vertical lineto(V Y)：画垂直线到指定的Y坐标位置

   - C = curveto(C X1,Y1,X2,Y2,ENDX,ENDY)：三次贝赛曲线

   - S = smooth curveto(S X2,Y2,ENDX,ENDY)

   - Q = quadratic Belzier curve(Q X,Y,ENDX,ENDY)：二次贝赛曲线

   - T = smooth quadratic Belzier curveto(T ENDX,ENDY)：映射

   - A = elliptical Arc(A RX,RY,XROTATION,FLAG1,FLAG2,X,Y)：弧线

   - Z = closepath()：关闭路径

2. 使用原则

   - 坐标轴为以(0,0)为中心，X轴水平向右，Y轴水平向下

   - 所有指令大小写均可。大写绝对定位，参照全局坐标系；小写相对定位，参照父容器坐标系

   - 指令和数据间的空格可以省略

   - 同一指令出现多次可以只用一个

#### Android Studio简单使用svg

- 首先在drawable下创建一个资源文件,类型选择vector,通过path属性指定颜色和轨迹画出图形

  ```

        //通过path设置颜色,画出图形路径,这里的name便于执行动画作用于它
    
    
    ```
    
    ```
     ![5c85dd6b3f864](https://i.loli.net/2019/03/11/5c85dd6b3f864.png)
    ```

- ImageView通过app:srcCompat属性设置vector资源,也可以做选择器，把定义的svg设置为背景给button

- 为vector定义渐变动画(使用svg当然不是为了实现这么简单的功能)

  ```

  //在animator下定义动画资源,实现颜色值的变化,repeatMode设置动画重复执行

    ```

- 然后在drawable下定义粘合剂(关联vector资源和动画的资源文件)，类型为animated-vector

  ```

        //指定动画和动画作用的元素
    
    
    
    ```

- 然后在布局中把资源设置给ImageView

- 在activity中激活vector动画

  ```
  public void anim(View v){
          ImageView imageView= (ImageView) v;
          Drawable drawable=imageView.getDrawable();
          if(drawable instanceof Animatable){
              ((Animatable)drawable).start();
          }
      }
  ```

###### 其它svg动画实现原理类似，只不过动画作用的属性不同而已，通过作用于绘制修剪路径(trimPathEnd)或画笔颜色(strokeColor)或路径数据(pathData)实现具体的动画.(知识体系来源于徐宜生老师)

## vector动画与bitmap原图对比

###### 简单区别位图和矢量图：位图是基于像素描绘的图像，而矢量图是基于贝塞尔曲线描述的图形图像

###### png栅格图可以借助GPU进行渲染，渲染效率高，Vector体积小，缩放不失真，vector只能借助CPU解析运算，无法借助GPU渲染

#### 开发中使用哪个主要从图像复杂度和图像更新频率考虑，参考以下几点

1. Bitmap的绘制效率不一定比Vector高，它们有一定的平衡点，当Vector比较简单时，其效率是一定比Bitmap

高的，所以为保证Vector高效率，Vector需要更简单，pathData需要更精准、简单，当Vector复杂时，就需要

bitmap来代替了

2. Vector适用于ICON、Button、ImageView等小的图标，或者是需要的动画效果，由于bitmap在CPU中有缓存，

而Vector没有，所以Vector 不能频繁重绘

3. Vector图像过于复杂时，不仅仅要注意绘制效率，初始化效率也是需要考虑的因素

4. svg加载速度会快于png，渲染慢于png，但是加载速度的提升弥补了绘制的速度和缺陷

###### [源代码github下载地址](https://github.com/Mojianxi/AndroidVerctorDemo.git)
