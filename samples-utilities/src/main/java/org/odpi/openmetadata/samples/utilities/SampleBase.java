/* SPDX-License-Identifier: Apache 2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.openmetadata.samples.utilities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import static java.lang.System.exit;

/**
 * SampleBase provides the common functions for a sample that calls Egeria's Open Metadata Services as a main program.
 */
public abstract class SampleBase
{
    /**
     * Run the sample.
     *
     * @param serverName name of the server to connect to
     * @param serverPlatformRootURL the network address of the server running the OMAS REST servers
     * @param userId calling user
     */
    public abstract void runSample(String serverName,
                                   String serverPlatformRootURL,
                                   String userId);


    /**
     * This method gets the serverName that the sample will use to issue calls to the server.
     * If arguments are supplied then the second parameter is used as a serverName.
     * If no serverName is supplied then prompt the user to enter a valid serverName, enter means to use the default serverName.
     *
     * @param args arguments supplied
     * @return the serverName to use on the calls to the server
     * @throws IOException IO exception occurred while getting input from the user.
     */
    protected static String getServerName(String[] args) throws IOException
    {
        String name;
        if (args.length > 1)
        {
            name = args[1];
        }
        else
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter an OMAG Server Name. Press enter to get the default (" + SampleConstants.DEFAULT_SERVER_NAME + ")) :");
            name = br.readLine();
            if (name.equals(""))
            {
                name = SampleConstants.DEFAULT_SERVER_NAME;
            }

        }

        return name;
    }


    /**
     * This method gets the userId that the sample will use to issue calls to the server.
     * If arguments are supplied then the third parameter is used as a userId.
     * If no userId is supplied then prompt the user to enter a valid userId, enter means to use the default userId.
     *
     * @param args arguments supplied
     * @return the userId to use on the calls to the server
     * @throws IOException IO exception occurred while getting input from the user.
     */
    protected static String getUserId(String[] args) throws IOException
    {
        String userId;
        if (args.length > 2)
        {
            userId = args[2];
        }
        else
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a userId. Press enter to get the default (" + SampleConstants.USERID + ")) :");
            userId = br.readLine();
            if (userId.equals(""))
            {
                userId = SampleConstants.USERID;
            }

        }

        return userId;
    }


    /**
     * This method gets the url that the sample will use to issue calls to the server.
     * If arguments are supplied then the first parameter is used as a url.
     * If no url is supplied then prompt the user to enter a valid url, enter means to use the default url.
     *
     * @param args arguments supplied
     * @return the url to use on the calls to the server
     * @throws IOException IO exception occurred while getting input from the user.
     */
    protected static String getUrl(String[] args) throws IOException
    {
        String url;

        if (args.length > 0)
        {
            url = args[0];
        }
        else
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a URL. Press enter to get the default (" + SampleConstants.DEFAULT_URL + ".)) :");
            url = br.readLine();
            if (url.equals(""))
            {
                url = SampleConstants.DEFAULT_URL;
            }
        }
        return url;
    }
}
