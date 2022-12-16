public class Layer {

    private int nodesIn, nodesOut;
    private double[][] weights;
    private double[] biases;
    private double[] outputs;

    public Layer(int nodesIn, int nodesOut) {
        this.nodesIn = nodesIn;
        this.nodesOut = nodesOut;
        weights = new double[nodesIn][nodesOut];
        biases = new double[nodesIn];
        outputs = new double[nodesOut];
    }

    public double[] calculateOutputs(double[] inputs) {
        for (int i = 0; i < this.nodesOut; i++) {
            outputs[i] = biases[i];
            for (int j = 0; j < this.nodesIn; j++) {
                outputs[i] += weights[j][i] * inputs[j];
            }
        }
        return this.outputs;
    }

    public int getNodesIn() {
        return this.nodesIn;
    }

    public int getNodesOut() {
        return this.nodesOut;
    }
}
