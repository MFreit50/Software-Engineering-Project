Pictures labeled "after" are taken after improvements to our code
Pictures labeled "before" are taken before improvements to our code

These results were gathered from jdk Java Mission Control.
Both scripts were given 1,000,000 (one million) of the same randomly generated numbers to factor
Both scripts were flight recorded for 5 minutes (regardless of if they finished facatoring)

Observable results:
Both cases use a significant amount of memory relative to total memory available:
    after_memory uses a significant amount of memory (over 1 Gib) which is quickly cleared
    before_memory uses between 60-200Mib for an extended time
The improved script performs its task significantly quicker:
    after_processes demonstrates a sharp use in cpu usage which quickly diminishes
    before_processes demonstrates a similar sharp cpu usage which slowly diminishes as the program finishes its task