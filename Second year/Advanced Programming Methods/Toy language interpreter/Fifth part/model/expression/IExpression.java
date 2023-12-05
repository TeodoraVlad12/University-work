package model.expression;

import exceptions.MyException;
import model.utils.MyIDictionary;
import model.utils.MyIHeap;
import model.value.Value;

public interface IExpression {
    Value eval(MyIDictionary<String, Value> symTable, MyIHeap<Value> heap) throws MyException;
    IExpression deepCopy();
}
