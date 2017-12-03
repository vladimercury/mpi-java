package com.jacobi.jacobi;

import com.jacobi.model.LinearSystem;
import com.jacobi.model.Vector;

public interface JacobiSolver {
    Vector solve(LinearSystem system, Vector estimation);
}
