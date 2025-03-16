class GFG{

// Function to maintain the case, X>=Y
static boolean swapXandY(char []str, int X, int Y)
{
    int N = str.length;

    // To maintain X>=Y
    X = X + Y;
    Y = X - Y;
    X = X - Y;

    for(int i = 0; i < N; i++)
    {

        // Replace 'p' to 'r'
        if (str[i] == 'p') 
        {
            str[i] = 'r';
        }

        // Replace 'r' to 'p'.
        else if (str[i] == 'r')
        {
            str[i] = 'p';
        }
    }
    return true;
}

// Function to return the maximum cost
static int maxCost(String str, int X, int Y)
{
    
    // Stores the length of the String
    int N = str.length();

    // To maintain X>=Y.
    if (Y > X) 
    {
        swapXandY(str.toCharArray(), X, Y);
    }

    // Stores the maximum cost
    int res = 0;

    // Stores the count of 'p'
    // after removal of all "pr"
    // subStrings up to str[i]
    int countP = 0;

    // Stores the count of 'r'
    // after removal of all "pr"
    // subStrings up to str[i]
    int countR = 0;

    // Stack to maintain the order of
    // characters after removal of
    // subStrings
    for(int i = 0; i < N; i++)
    {
        if (str.charAt(i) == 'p') 
        {
            countP++;
        }
        else if (str.charAt(i) == 'r') 
        {
            
            // If subString "pr"
            // is removed
            if (countP > 0) 
            {
                countP--;

                // Increase cost by X
                res += X;
            }
            else
                countR++;
        }
        else 
        {

            // If any subString "rp"
            // left in the Stack
            res += Math.min(countP, countR) * Y;
            countP = 0;
            countR = 0;
        }
    }

    // If any subString "rp"
    // left in the Stack
    res += Math.min(countP, countR) * Y;
    return res;
}
