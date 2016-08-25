package edu.truman.leh.math;

/**
 * The Vector2D class defines a vector in two-dimensional space.
 * Instances of this class are guaranteed to be immutable.
 * @author Hieu Le
 * @version November 17th, 2015
 */
public final class Vector2D
{
   
   // The vector components
   private double x;
   private double y;
   
   /**
    * Constructs a vector from its orthogonal components.
    * @param x the horizontal component
    * @param y the vertical component
    */
   public Vector2D(double x, double y)
   {
      this.x = x;
      this.y = y;
   }
   
   /**
    * Returns the vector's horizontal component.
    * @return the abscissa
    */
   public double getX()
   {
      return x;
   }
   
   /**
    * Returns the vector's vertical component.
    * @return the ordinate
    */
   public double getY()
   {
      return y;
   }
   
   /**
    * Returns the vector's magnitude.
    * @return the length or magnitude
    */
   public double getLength()
   {
      return Math.sqrt(x * x + y * y);
   }
   
   /**
    * Returns the dot product of this instance with another vector v.
    * @param v the second vector
    * @return the dot product with v
    */
   public double dotProduct(Vector2D v)
   {
      return x * v.x + y * v.y;
   }
   
   /**
    * Returns a unit vector aligned with this instance.
    * @return a new normalized vector
    * @throws ArithmeticException if the magnitude of this instance is zero,
    * since a zero vector cannot be normalized
    */
   public Vector2D normalize() throws ArithmeticException
   {
      if (getLength() == 0)
         throw new ArithmeticException("Zero vector cannot be normalized");
      return new Vector2D(x / getLength(), y / getLength());
   }
   
   /**
    * Returns a vector with the same magnitude but aligned in the opposite
    * direction as this instance.
    * @return the negation of this vector
    */
   public Vector2D negate()
   {
      return new Vector2D(-x, -y);
   }
   
   /**
    * Returns a vector equal to the addition of a vector v to this instance.
    * @param v the vector to add
    * @return the vector sum of this instance with v
    */
   public Vector2D add(Vector2D v)
   {
      return new Vector2D(x + v.x, y + v.y);
   }
   
   /**
    * Returns a vector equal to the multiplication of this instance with a 
    * scalar quantiy s.
    * @param s the scalar factor
    * @return the multiplication of this instance with s
    */
   public Vector2D scalarMultiply(double s)
   {
      return new Vector2D(s * x, s * y);
   }
   
}
