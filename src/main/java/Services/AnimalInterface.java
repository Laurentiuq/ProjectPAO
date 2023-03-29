package Services;

import Model.Animal;

public interface AnimalInterface {
    // compute the food needed by an animal in calories
    public void computeFoodNeeded(Animal animal);
    // compute the value of an animal in dollars depending on the type of animal, size, weight, age
    public double computeValue(Animal animal);

//    public double computeFoodNeeded(Cow cow);
}
