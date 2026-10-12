class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        String result = "";

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;
            }

            else if (part.equals("..")) {
                int lastSlash = result.lastIndexOf("/");

                if (lastSlash >= 0) {
                    result = result.substring(0, lastSlash);
                }
            }

            else {
                result = result + "/" + part;
            }
        }

        if (result.equals("")) {
            return "/";
        }

        return result;
    }
}
