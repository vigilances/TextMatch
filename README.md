# TextMatch

使用引擎来进行模糊匹配
Use  this engine to  fuzzy match

Step1

拷贝assets下的模型文件到你的工程，并写入你的设备中，后面初始引擎需要传入该路径
Copy the modelfile in assets to your project,then write these into your devices,
because init the engine  need the path of these files

![](https://github.com/vigilances/TextMatch/blob/master/image/assets.png)

Step2

初始化引擎,详见工程（代码很简单，就一个工具类和native的入口类）
Init the engine，see details in project(TextMatch and NameMate)

 /**
     * call this to init the engine
     * @params:
     * ModelFilePath: the path of modelFile
     * inputList: source list ,divide by delimiter
     * minScore: only return the result larger than minScore
     * delimiter: the delimiter(like: "#" "*")
     * @return:
     * 1: succeed;
     * 0: failed;
     * -1: modelFilePath params error;
     * -2: inputList params error;
     * -3: delimiter params error;
     * <p>
     * notice:
     * 1.if you init the engine frequently ,you must call freeInstance() first
     */

    public static native int textInitial(String modelFilePath, String inputList, String delimiter, int minScore);

    String inPut="安捷汽车#斌#柯萧#小狗#超儿#曹小龙#程丽红"
     private void initEgine() {
            NameMate.getInstance(this).setFree();
            NameMate.getInstance(this).init(this, inPut);
        }

Step3

执行匹配，返回结果（native方法和工具类方法）
do textmatch ,and return the result
  /**
     *
     * @param :
     * strOut:return the arrays of the results(like:["李四{100.00000}","张三{100.00000}"])
     * whetherScore  should return score 1:yes 0:no
     * @return :
     * 1: succeed;
     * 0: inner error;
     * -1: the inputText is empty;
     */
    public static native int textScore(String inputText, Object[] strOut, int whetherScore);


    String[] matchName = NameMate.getInstance(this).TextScore("曹小龙", 4, 1);
    mathName=["曹小龙{100.00000}","陈小娟{53.19474}","小狗{48.46548}","柯萧{41.20273}"]




Step4

实际效果
Actual effect

![](https://github.com/vigilances/TextMatch/blob/master/image/usage.png)
