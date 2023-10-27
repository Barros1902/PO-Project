package xxl.core;

import xxl.core.exception.ArrayCharException;

public class Product extends RangeFunction {

	String _name = "PRODUCT";
    Product(Gama gama) {
        super(gama);
    }
    @Override
    public int evalInt() throws ArrayCharException {
        if (verifyInputInt()) {
            throw new ArrayCharException();
        }

        int prod = 1;
        for (Cell cell : getCells()) {
            if (verifyIsNull(cell)){
                throw new ArrayCharException();
            }
            prod *= cell.evalInt();
        }
        return prod;
    }
    @Override
    public Content getContent() {
        return new Product(_gama.copy());
    }

    @Override
    public String toString() {
        try {
            return String.valueOf(evalInt()) + "=PRODUCT(" + _gama.toString() + ")";
        } catch (Exception e) {
            return "#VALUE" + "=PRODUCT(" + _gama.toString() + ")";
        }
    }

	@Override
	public void accept(ContentVisitor contentvisitor){

		contentvisitor.visitProduct(this);
		
	}

	@Override
	public String getName(){

		return _name;
	}
}

