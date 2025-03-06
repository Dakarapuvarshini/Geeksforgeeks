class GFG {
 
    // Function to swap even
    // and odd bits
    static int swapBits(int x)
    {
        for (int i = 0; i < 32; i += 2) {
            int i_bit = (x >> i) & 1; // find i th bit
            int i_1_bit
                = (x >> (i + 1)) & 1; // find i+1 th bit
 
            x = x - (i_bit << i) // remove i_bit
                - (i_1_bit << (i + 1)) // remove i+1 th bit
                + (i_bit
                   << (i + 1)) // put i_bit at i+1 location
                + (i_1_bit
                   << i); // put i+1 bit at i location
        }
        return x;
    }
 
