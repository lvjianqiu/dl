import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.DenseVector;

/**
 * Created by lvjq on 2/19/18.
 */

public class GradientDescent {
    private double[][] trainingData;
    private float learningRate;
    private double[] weights;
    private double[] trainingResult;
    private int featureNumber = 0;

    public GradientDescent(double[][] trainingData,double[] trainingResult, float learningRate){
        this.trainingData = trainingData;
        this.learningRate = learningRate;
        this.trainingResult = trainingResult;
        if(trainingData != null && trainingData.length > 0)
            featureNumber = trainingData[0].length;
        initialWeights();
    }
    private void initialWeights(){
        if(featureNumber <= 0){
            return;
        }
        if(weights == null){
            weights = new double[trainingData[0].length];
            for(int i=0; i< featureNumber; i++){
                weights[i] =  Math.random();
                System.out.println(weights[i]);
            }
        }

    }
    public void fit(){

    }
    public double predict(double[] predictData){
        DenseVector weight = new DenseVector(weights);
        DenseVector result = new DenseVector(1);
        double[][] predictDatas = new double[1][predictData.length];
        predictDatas[0]= predictData;
        DenseMatrix data = new DenseMatrix(predictDatas);
        data.mult(weight,result);

        System.out.println(weight.toString());
        System.out.println(data.toString());
        System.out.println(result.toString());
        return result.getData()[0];
    }
    public static void main(String[] args){
        double[][] feature = new double[1][3];
        feature[0][0] = 1;
        feature[0][1] = 1;
        feature[0][2] = 1;
        GradientDescent gd = new GradientDescent(feature,null,1);
        double[] predict = {3,5,6};
        System.out.println(gd.predict(predict));
    }
}
