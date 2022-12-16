public class Network {
    
    private Layer[] layers;
    private int numInputs, numOutputs;

    public Network(int numInputs, int numOutputs, String layerNodes) {
        this.numInputs = numInputs;
        this.numOutputs = numOutputs;
        String[] numNodes = layerNodes.split(",");
        this.layers = new Layer[numNodes.length];
        for (int i = 1; i < this.layers.length-1; i++) {
            this.layers[i] = new Layer(Integer.parseInt(numNodes[i]), Integer.parseInt(numNodes[i+1]));
        }
        layers[0] = new Layer(numInputs, layers[1].getNodesIn());
        layers[layers.length-1] = new Layer(layers[layers.length-2].getNodesOut(), numOutputs);
    }

    public double[] calculateOutput(double[] inputData) {
        double[] output = inputData;
        for (int i = 0; i < layers.length; i++) {
            output = layers[i].calculateOutputs(output);
        }
        return output;
    }
}
