package xxl.core;

import xxl.core.exception.ArrayCharException;

public class Average extends RangeFunction {

	String _name = "AVERAGE";

    Average(Gama gama) {
        super(gama);
    }

    @Override
    public int evalInt() throws ArrayCharException{
        if (verifyInputInt()) {
            throw new ArrayCharException();
        }
        int sum = 0;
        for (Cell cell : getCells()) {
            if (verifyIsNull(cell)){
                throw new ArrayCharException();
            }
            sum += cell.evalInt();
        }
        return sum/getCells().size();
    }
    public Content getContent() {
        return new Average(_gama.copy());
    }
    @Override
    public String toString() {
        try {
            return String.valueOf(evalInt()) + "=AVERAGE(" + _gama.toString() + ")";
        } catch (Exception e) {
            return "#VALUE" + "=AVERAGE(" + _gama.toString() + ")";
        }
    }

	@Override
	public void accept(ContentVisitor contentvisitor){

		contentvisitor.visitAverage(this);
		
	}

	@Override
	public String getName(){

		return _name;
	}
}

