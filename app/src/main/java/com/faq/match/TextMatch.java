package com.faq.match;

public class TextMatch {

    static {
        System.loadLibrary("textMatch");
    }


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


    /**
     * call this to math the text
     * @param :
     * strOut:return the arrays of the results(like:["李四{100.00000}","张三{100.00000}"])
     * whetherScore  should return score 1:yes 0:no
     * @return :
     * 1: succeed;
     * 0: inner error;
     * -1: the inputText is empty;
     */
    public static native int textScore(String inputText, Object[] strOut, int whetherScore);


    public static native int freeInstance();

}
