**Mini Linear Regression Framework (Lab 4)**

Small Java project; part of university coursework on machine learning. The goal was to create a flexible, modular framework for linear regression using different datasets and optimization algorithms.

- Supports raw data and standardized data (normalization).

- Implements linear regression models with gradient-based optimization.

- Includes two learning algorithms:

    - Gradient Descent (GD) – full-batch updates, stops when convergence is reached.
    - Stochastic Gradient Descent (SGD) – mini-batch updates, faster but noisier.

- Provides a SupervisedLearner wrapper that ties datasets and algorithms together and handles predictions automatically.


**Structure**

Dataset (abstract) – base class for datasets; defines transform() and output().  
RawDataset / StandardizedDataset – concrete dataset types.  
Model – stores parameters θ and computes predictions.  
Algorithm (abstract) – base class for learning algorithms.  
GradientDescent / StochasticGradientDescent – concrete optimization algorithms.  
SupervisedLearner – ties datasets and algorithms together, makes predictions easy.  
Vector / Record – simple helper classes for numerical operations and storing data points.  
TestDataset / TestLearner – example programs showing how to use the framework.  

How to run:  
Compile all .java files:  
javac *.java 


Run tests:

java TestDataset
java TestLearner


You’ll see the datasets, standardized versions, and predictions from both GD and SGD printed out.