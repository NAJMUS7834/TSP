package com.getwayssolution.www;

public class Test {
	static int n = 3;
	static final int VISITED_ALL = (1<<n) -1;
	static int[][] dist = {{1,0,0},{1,0,0},{1,9,1}};
	
	
	public static int tsp(int mask,int pos) 
	{
		
		int ans = Integer.MAX_VALUE;
		//if all city visited we return distance of current and source city
		if(mask == VISITED_ALL)
		{
			return dist[pos][0];
		}
		//try to visit unvisited city
		for(int city = 0; city < n; city++)
		{
			//if city is not visited
			if ((mask & (1<<city)) == 0)
			{
				int newAns = dist[pos][city] + tsp(mask|(1<<city), city);
				ans = Math.min(ans,newAns);
			}
		}
		
		return ans;
		
	}
	
	

	public static void main(String[] args) {
		int distance = tsp(1,0);
		System.out.println(distance);
	}

}
