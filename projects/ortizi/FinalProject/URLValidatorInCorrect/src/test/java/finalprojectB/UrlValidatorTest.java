/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;





/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("http://www.amazon.com"));
	   System.out.println(urlVal.isValid("http://www.google.com:80/test1")); //arbitrary url test
	   
	   //Example URI from rfc2396 that should work but a couple of them failed anyways
	   System.out.println(urlVal.isValid("ftp://ftp.is.co.za/rfc/rfc1808.txt")); //failed
	   System.out.println(urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles")); //pass
	   System.out.println(urlVal.isValid("http://www.math.uio.no/faq/compression-faq/part1.html"));  //failed
	   System.out.println(urlVal.isValid("mailto:mduerst@ifi.unizh.ch"));  //failed
	   System.out.println(urlVal.isValid("news:comp.infosystems.www.servers.unix")); //failed
	   System.out.println(urlVal.isValid("telnet://melvyl.ucop.edu/"));  //pass


   }
   
   //Taking a closer look at the scheme
   //Tests the scheme portion of the URL
   public void testYourFirstPartition()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   System.out.println(urlVal.isValid("asdf://www.google.com:80/test1")); //scheme test
	   System.out.println(urlVal.isValid("a+://www.google.com:80/test1")); //scheme test
	   System.out.println(urlVal.isValid("a-://www.google.com:80/test1")); //scheme test
	   System.out.println(urlVal.isValid("a.://www.google.com:80/test1")); //scheme test
	   
	   //Failed tests
	   System.out.println(urlVal.isValid("a/://www.google.com:80/test1")); //no slashes in the scheme allowed
	   System.out.println(urlVal.isValid(""));
	   
	   
	   
   }
   
   //Taking a closer look at the authority/path
   //Tests the authority portion of the url
   public void testYourSecondPartition(){
	   
   }
   
   
   public void testIsValid()
   {
	   for(int i = 0;i<10000;i++)
	   {
		   
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
