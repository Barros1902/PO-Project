package xxl.core;

import xxl.core.exception.IntFailedException;

public class Concat extends RangeFunction {

    Concat(Gama gama) {
        super(gama);
    }
    @Override
    public String evalString() throws IntFailedException{
        //TODO: implement this
        StringBuilder concat = new StringBuilder();
        concat.append("'");
        for (Cell cell : getCells()) {
            concat.append(cell.evalString().substring(1));
        }
        return concat.toString();
    }
    @Override
    public Content getContent() {
        return new Concat(_gama.copy());
    }
    public String toString(){
        try {
            return evalString() + "=CONCAT(" + _gama.toString() + ")";
        } catch (Exception e) {
            return "#VALUE" + "=CONCAT(" + _gama.toString() + ")";
        }
    }

	@Override
	public void accept(ContentVisitor contentvisitor){

		contentvisitor.visitConcat(this);
		
	}
}

