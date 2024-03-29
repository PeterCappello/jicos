/* ************************************************************************* *
 *                                                                           *
 *        Copyright (c) 2004 Peter Cappello  <cappello@cs.ucsb.edu>          *
 *                                                                           *
 *    Permission is hereby granted, free of charge, to any person obtaining  *
 *  a copy of this software and associated documentation files (the          *
 *  "Software"), to deal in the Software without restriction, including      *
 *  without limitation the rights to use, copy, modify, merge, publish,      *
 *  distribute, sublicense, and/or sell copies of the Software, and to       *
 *  permit persons to whom the Software is furnished to do so, subject to    *
 *  the following conditions:                                                *
 *                                                                           *
 *    The above copyright notice and this permission notice shall be         *
 *  included in all copies or substantial portions of the Software.          *
 *                                                                           *
 *    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,        *
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF       *
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.   *
 *  IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY     *
 *  CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,     *
 *  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE        *
 *  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.                   *
 *                                                                           *
 * ************************************************************************* */

/**
 * Q: Queue of Solution objects
 *
 * @version 1
 * @author  Peter Cappello
 */

package edu.ucsb.cs.jicos.applications.branchandbound;

//public final class Q extends java.util.LinkedList
//{
//    /** Add a Solution object to the Q.
//     * @param solution A, typically partial, Solution object.
//     */    
//    public boolean add(Solution solution)
//    { addFirst( solution );  return true;}
//    
//   public Object remove() { return removeLast(); }
//}

// 1. parameterize LinkedList<Solution> and make remove return type Solution
// 2. replace method implementation to just super.method
// 3. eliminate class: Use Queue interface and LinkedList<Solution> 
//    implementation in BranchAndBound class

public final class Q extends java.util.LinkedList<Solution>
{
    /** Add a Solution object to the Q.
     * @param solution A, typically partial, Solution object.
     */    
    public boolean add(Solution solution)
    { return super.add(solution);}
    
   public Solution remove() { return super.remove(); }
}
