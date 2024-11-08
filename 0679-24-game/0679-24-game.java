class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int num: cards){
            nums.add((double) num);
        }       
        return canGet24(nums);
    }

    public boolean canGet24(List<Double> nums){
        if(nums.size() == 1){
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for(int i=0; i<nums.size(); i++){
            for(int j=0; j<nums.size(); j++){
                if(i != j){
                    List<Double> next = new ArrayList<>();
                    for(int k=0; k<nums.size(); k++){
                        if(k != i && k != j){
                            next.add(nums.get(k));
                        }
                    }

                    for(double res: compute(nums.get(i), nums.get(j))){
                        next.add(res);
                        if(canGet24(next))
                            return true;

                        next.remove(next.size() - 1);    
                    }
                }
            }
        }
        return false;
    }

    public List<Double> compute(double a, double b){
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if(b != 0) res.add(a / b);
        if(a != 0) res.add(b / a);
        return res;
    }
}