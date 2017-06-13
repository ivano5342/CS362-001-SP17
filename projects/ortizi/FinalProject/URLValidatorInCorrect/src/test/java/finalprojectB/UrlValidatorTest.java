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

    private ResultPair[] urlSchemes = {
        new ResultPair("http://", true),
        new ResultPair("https://", true),
        new ResultPair("ftp://", true),
        new ResultPair("2htp://", false),
        new ResultPair("http:", false)
    };

    private ResultPair[] urlAuthorities = {
        new ResultPair("", false),
        new ResultPair("www.google.com", true),
        new ResultPair("0.0.0.0", true),
        new ResultPair("255.255.255.255", true),
        new ResultPair("asdf.gr", true),
        new ResultPair("0.0.0", false),
        new ResultPair("1.2.3.4.5", false),
        new ResultPair("", false),
        new ResultPair("localhost", true),
        new ResultPair("asdf", false),
        new ResultPair(".5.6.7.8", false)
    };

    private ResultPair[] urlPorts = {
        new ResultPair(":80", true),
        new ResultPair(":12345", true),
        new ResultPair(":a", false),
        new ResultPair(":-3", false)
    };

    private ResultPair[] urlPaths = {
        new ResultPair("/asdf", true),
        new ResultPair("/asdf123", true),
        new ResultPair("/asdf/qwerty", true),
        new ResultPair("", true),
        new ResultPair("/asdf//qwerty", false),
        new ResultPair("/..", false),
        new ResultPair("/#/asdf", false)
    };

    private ResultPair[] urlQueries = {
        new ResultPair("?file=asdf", true),
        new ResultPair("?file=asdf&blah=true", true),
        new ResultPair("", true),

    };

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
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       boolean val = true;
	   for(int s = 0; s < urlSchemes.length; s++){
           if (urlSchemes[s].valid){
               val = true;
           }
           else{
               val = false;
           }
            for(int a = 0; a < urlAuthorities.length; a++){
                if (!urlAuthorities[a].valid && val){
                    val = false;
                }
                for(int po = 0; po < urlPorts.length; po++){
                    if (!urlPorts[po].valid && val){
                        val = false;
                    }
                    for(int pa = 0; pa < urlPaths.length; pa++){
                        if (!urlPaths[pa].valid && val){
                            val = false;
                        }
                        for(int q = 0; q < urlQueries.length; q++){
                            String url = urlSchemes[s].item + urlAuthorities[a].item + urlPorts[po].item + urlPaths[pa].item + urlQueries[q].item;
                            if (!urlQueries[q].valid && val){
                                val = false; 
                            }
                            System.out.println("Testing url: " + url);
                            System.out.println("Expected: " + val + " Actual: " + urlVal.isValid(url) + "\n");
                        }
                    }
                }
            }
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
