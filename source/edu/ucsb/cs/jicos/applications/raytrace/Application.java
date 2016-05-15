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
 * Application.java
 *
 * Created on December 9, 2003, 7:07 PM
 *
 * @author  Chris Coakley
 */

package edu.ucsb.cs.jicos.applications.raytrace;
import edu.ucsb.cs.jicos.services.Environment;
import edu.ucsb.cs.jicos.services.HspAgent;
import edu.ucsb.cs.jicos.services.Client2Hsp;
import edu.ucsb.cs.jicos.services.Invoice;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.io.FileOutputStream;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Application
{
    
    /** Creates a new instance of Application */
    public Application()
    {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        RTScene scene = new RTScene(800,800,4);

        // construct the computation's Environment
        Environment environment = new Environment( scene, null );

        // construct root task
        Tracer t = new Tracer(new Rectangle(scene.getX(), scene.getY()), new Rectangle(scene.getX(), scene.getY()));

        // get a reference to a Hosting Service Provider
        HspAgent agent = new HspAgent( "test" );
        Client2Hsp hsp = agent.getClient2Hsp();

        // login
        hsp.login( environment );

        // compute
        RTSolution solution = (RTSolution) hsp.compute( t );

        // logout
        Invoice invoice = hsp.logout();

        // print the solution & invoice
        System.out.println( invoice );
        
        // save the solution to disk
        FileOutputStream f = new FileOutputStream("goodtest.jpg");
        JPEGImageEncoder j = JPEGCodec.createJPEGEncoder(f);
        j.encode((BufferedImage)solution.getImage());
        System.exit(0);
    }
    
}
