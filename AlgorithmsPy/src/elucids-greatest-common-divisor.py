def findGcd(number1,number2):
    if(number1>number2):
        greaterNumber=number1;
        smallerNumber=number2;
    else:
        greaterNumber=number2;
        smallerNumber=number1;
    remainder=smallerNumber%greaterNumber;
    while(remainder>0):
        greaterNumber=smallerNumber;
        smallerNumber=remainder;
        remainder=smallerNumber%greaterNumber;
    return smallerNumber;

print(findGcd(39,13))