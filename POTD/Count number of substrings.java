public class CountKSubStr
{
    // Function to count number of substrings
    // with exactly k unique characters
    int countkDist(String str, int k)
    {
        // Initialize result
        int res = 0;

        int n = str.length();

        // To store seen characters from 'a' to 'z'
        boolean seen[] = new boolean[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            int distCount = 0;

            // mark all chars as unseen
            Arrays.fill(seen, false);

            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                // If this is a new character for this
                // substring, increment dist_count.
                if (!seen[str.charAt(j) - 'a'])
                    distCount++;

                // mark current char as seen
                seen[str.charAt(j) - 'a'] = true;

                // If distinct character count becomes k,
                // then increment result.
                if (distCount == k)
                    res++;
            }
        }

        return res;
    }
