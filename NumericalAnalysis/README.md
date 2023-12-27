# Numerical Analysis (MTA 4010)
## Abstract
<br>
  The project considers an n by n symmetric square matrix A and seeks an eigenvalue 𝜆 ∈ 𝑅 and eigenvector $𝑣 ∈ 𝑅^{n}$ pair which satisfies Av = 𝜆v. This is only n nonlinear equations for n+1 unknown v where 𝜆 and all n components in v. To make the eigenvector unique, we will
add another equation, $1 = \frac{1}{2}\left \|| v \right \||^{2}_{2}$
into the system A. The given equation helps to construct the Jacobian matrix during the computation. Also in order to convert these equations into root-finding problems we will define a new column vector X which has an n+1 dimensional vector with all v components and the last entry is 𝜆. It rewrites the equations in the form f(x) = 0 by moving all terms.

  The project investigates comparing numerical methods we discussed in class to the eigenvalue pair. The project implements three different methods for finding eigenvalue and eigenvector pair: 1. Newton’s method, 2. Broyden method, and 3. “Good” Broyden method and compare average execution time and error reduction per iteration. In general MatLab and Python are common choices for implementing numerical analysis due to their rich linear algebra libraries. However, I chose Java because it is my strongest language, and I found an interesting library that is the Apache Commons Math library for matrix computations. I would love to explore it and it allows me to create real matrix objects for its calculation. This experience will be beneficial to unitize other programming languages for my future numerical analysis projects.

Moreover, the class discussed a variety of algorithms for solving Ax = b to Cind a solution vector. This project also implements three algorithms to Cind solution vector x: 1. Steepest Descent, 2. Conjugate Gradient, and 3. QR Factorization algorithms and compare average execution time and error reduction per iteration.

The project verifies what I understand in this class and becomes a transition to handle a large-scale matrix. I am passionate about linear algebra application to computer science, such as machine learning and artificial intelligence, especially natural language processing and neural network training. This project helped me to understand each algorithm clearly by implementing them and getting used to large-size matrix calculation and optimization problems.

[Implementation detailed in Java](https://github.com/keiakihito/PersonalProjects/tree/main/NumericalAnalysis/FinalProject/src)

[Project reports](https://github.com/keiakihito/PersonalProjects/blob/main/NumericalAnalysis/Dcumentation/FinalProjectReport.pdf)
