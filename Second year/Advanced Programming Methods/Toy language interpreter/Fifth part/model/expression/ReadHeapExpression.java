package model.expression;

import exceptions.MyException;
import model.utils.MyIDictionary;
import model.utils.MyIHeap;
import model.value.RefValue;
import model.value.Value;

public class ReadHeapExpression implements IExpression{
    private final IExpression expression;

    public ReadHeapExpression(IExpression expression) {
        this.expression = expression;
    }




    @Override
    public Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Value> heap) throws MyException {
        Value value = expression.eval(symTable, heap);
        if (value instanceof RefValue) {
            RefValue refValue = (RefValue) value;
            if (heap.isDefined(refValue.getAddress()))
                return heap.getHeapValue(refValue.getAddress());
            else
                throw new MyException("The address is not defined on the heap!");
        } else
            throw new MyException(String.format("%s not of RefType", value));
    }

    @Override
    public IExpression deepCopy() {
        return new ReadHeapExpression(expression.deepCopy());
    }

    @Override
    public String toString() {
        return String.format("ReadHeap(%s)", expression);
    }
}