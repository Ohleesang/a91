
/**
 * 1~100 progresses : 각 작업의 진도 속도 가 적힌 정수 배열
 * 1~100 speeds : 각 작업의 개발속도가 적힌 정수 배열
 *
 * 이떄, 진도가 100%일때 배포가 가능하다
 *
 * 배포는 하루에 한번에 가능하다(단, 하루의 끝)
 *
 * 각 배포마다 몇개의 기능이 배포 되는지를 return!
 */




class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var output = mutableListOf<Int>()
        //map..? << ㄴㄴ key값 중복됨


        //가변 되므로 mutable 형으로 변환
        var progList = progresses.toMutableList()
        var speedList = speeds.toMutableList()
        var count = 0

        while(!progList.isEmpty()){
            //작업이 0개일떄 까지

            //애초에 첫번째가 끝나야 나머지가 같이 끝나는구조
            // 첫번째가 100% 될때까지 반복해야함.
            while(progList.first()<100){

                //작업 수행!
                for(i in progList.indices){
                    progList[i] += speedList[i]
                }

            }

            //첫번쨰 가 100 일경우 그 뒤의 인자는 완료 되어 있는지 확인해야한다.

            //첫번쨰 리스트 제거 후 카운트
            progList.removeFirst()
            speedList.removeFirst()
            count++

            try{
            while(progList.first()>=100) {//그 이후 완료된거 확인
                progList.removeFirst()
                speedList.removeFirst()
                count++
            }
            }catch(e : Exception){//마지막 인자값일경우 예외가 발생하므로
                output.add(count)
                break
            }

            //output 에 값 입력
            output.add(count)
            count = 0
        }

        answer = output.toIntArray()

        return answer
    }
}

fun main(){
    var a = Solution()
//    a.solution(intArrayOf(93,39,55), intArrayOf(1,30,5))
    //[2,1]   - 배포되는횟수 ...(0,1) , (2)
//    a.solution(intArrayOf(95,90,99,99,80,99), intArrayOf(1,1,1,1,1,1))
    //[1,3,2] - (0),(1,2,3),(4,5)
    a.solution(intArrayOf(90,90,90,90), intArrayOf(30,1,1,1))
    //[1, 3]
}