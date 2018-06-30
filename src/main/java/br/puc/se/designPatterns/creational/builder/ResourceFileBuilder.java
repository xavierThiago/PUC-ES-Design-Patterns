package br.puc.se.designPatterns.creational.builder;

public class ResourceFileBuilder implements InputBuilder<String> {

    private Input<String> input;
    
    public ResourceFileBuilder() {
        this.input = new Input<String>() {
            
            @Override
            public String getContent() {
                return "no content";
            }

        };
    }
    
    @Override
    public Input<String> build() {
        return this.input;
    }

    @Override
    public void fromResource(String resource) {
        this.input = new ResourceFileInput(resource);
    }
}
