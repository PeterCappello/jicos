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
 * @author  Peter Cappello
 */

package edu.ucsb.cs.jicos.examples.recursivematrixproduct;

import edu.ucsb.cs.jicos.services.*;


final class Application 
{
    public static void main ( String args[] ) throws Exception
    {        
        // unpack command-line arguments
        String hspDomainName = args[0];
        int n = Integer.parseInt( args[1] );
        
        // get a reference to a Hosting Service Provider
        HspAgent agent = new HspAgent( hspDomainName );
        Client2Hsp hsp = agent.getClient2Hsp();
                        
        // construct input       
        Matrix matrix = Matrix.makeMatrix( n );
        Object[] matrices = { matrix, matrix };
        
        // login
        Environment environment = new Environment( matrices, null );
        hsp.login( environment );

        // compute
        Task decomposeMatrix = new Decompose( 0, 0, 0, n ); 
        Matrix productMatrix = (Matrix) hsp.compute( decomposeMatrix );
        
        // logout
        hsp.logout();
        
        // print product matrix
        productMatrix.print();
    }
}
