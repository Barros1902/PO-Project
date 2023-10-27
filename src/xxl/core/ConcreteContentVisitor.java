package xxl.core;

public class ConcreteContentVisitor implements ContentVisitor  {

	public void visitContent(Content content){}


		public void visitLiterals(Literals literals){}

			public void visitNum(Num num){}
			public void visitNull(NULL _null){}
			public void visitCharArray(CharArray chararray){}
			
		public void visitReference(Reference reference){}

		public void visitFunction(Function function){}

			public void visitRangeFunction(RangeFunction rangefunction){}

				public void visitAverage(Average average){}
				public void visitConcat(Concat concat){}
				public void visitCoalesce(Coalesce coalesce){}
				public void visitProduct(Product product){}
			
			public void visitBinaryFunction(BinaryFunction binaryfunction){}

				public void visitSUB(SUB sub){}
				public void visitADD(ADD add){}
				public void visitDIV(DIV div){}
				public void visitMUL(MUL mul){}

}
