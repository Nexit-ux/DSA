class MedianFinder {
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0){
            maxHeap.add(num);
            return;
        }
        int left = maxHeap.peek();
        if(num < left){
            maxHeap.add(num);
            if( (maxHeap.size() - minHeap.size()) == 2){
                minHeap.add(maxHeap.remove());
            }
        }
        else{
            minHeap.add(num);
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.remove());
            }
        }
    }
    
    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        if(size % 2 != 0){
            return (double)maxHeap.peek();
        }
        else{
            double ans = (maxHeap.peek() + minHeap.peek())/2.0;
            return ans;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */