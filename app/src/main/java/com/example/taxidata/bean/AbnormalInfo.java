package com.example.taxidata.bean;

import java.util.List;

/**
 * @author: ODM
 * @date: 2019/8/21
 */
public class AbnormalInfo {

    /**
     * msg : success
     * code : 1
     * data : {"bar":{"title":"异常车辆数量分布","x":[1,2,3,4,5,6,7,8,9,10,11],"y":[382,811,798,955,725,922,46,470,790,460,650]},"pies":{"title":"异常车辆概率分布","pie":[{"area":0,"abnormal":0.6483,"normal":0.3517},{"area":1,"abnormal":0.5222,"normal":0.4778},{"area":2,"abnormal":0.4589,"normal":0.5411},{"area":3,"abnormal":0.29,"normal":0.71},{"area":4,"abnormal":0.1998,"normal":0.8002},{"area":5,"abnormal":0.5476,"normal":0.4524},{"area":6,"abnormal":0.4735,"normal":0.5265},{"area":7,"abnormal":0.9199,"normal":0.0801},{"area":8,"abnormal":0.5073,"normal":0.4927},{"area":9,"abnormal":0.5142,"normal":0.4858},{"area":10,"abnormal":0.4033,"normal":0.5967},{"area":11,"abnormal":0.9892,"normal":0.0108}]},"cars":{"normal_distribution":[0.06426373,0.3827749,0.8520558,0.37014769,0.42223424,0.56963216,0.63982495,0.70254477,0.20470247,0.06790777,0.99255217,0.73894742,0.65990171,0.57961428,0.07063356,0.59503219,0.89232095,0.88236465,0.78101472,0.7314493,0.31850466,0.062347,0.19801045,0.74821474],"abnormal":[{"license":"粤A5273","distribution":[0.0988,0.3677,0.9573,0.7892,0.8027,0.8155,0.473,0.6067,0.6387,0.7532,0.1587,0.7943,0.2529,0.7567,0.1728,0.5663,0.2777,0.1354,0.2971,0.5901,0.2507,0.172,0.3961,0.5143]},{"license":"粤A4781","distribution":[0.0285,0.6864,0.1494,0.0855,0.303,0.7447,0.4716,0.6145,0.7216,0.0685,0.5296,0.222,0.1677,0.936,0.2552,0.3112,0.2415,0.034,0.4689,0.6398,0.5549,0.7204,0.6617,0.6122]},{"license":"粤A6894","distribution":[0.9983,0.6478,0.2701,0.0341,0.4205,0.2859,0.6579,0.421,0.9703,0.97,0.8515,0.0669,0.4693,0.0061,0.1583,0.8396,0.0679,0.5034,0.6696,0.237,0.6135,0.5293,0.845,0.6835]},{"license":"粤A8069","distribution":[0.8352,0.4846,0.1378,0.9787,0.3448,0.6047,0.5754,0.042,0.9512,0.8873,0.1506,0.2732,0.7128,0.027,0.465,0.8524,0.7375,0.4462,0.8054,0.8291,0.4844,0.3507,0.3021,0.2851]},{"license":"粤A3078","distribution":[0.1293,0.5244,0.9795,0.5215,0.8353,0.825,0.3063,0.289,0.3119,0.6092,0.7448,0.496,0.2136,0.7755,0.2689,0.4788,0.9002,0.6705,0.5385,0.98,0.7109,0.4419,0.8315,0.6198]},{"license":"粤A5621","distribution":[0.1955,0.0381,0.0077,0.3351,0.502,0.5227,0.6222,0.2901,0.1335,0.8176,0.8332,0.7523,0.6883,0.1125,0.9112,0.0665,0.0744,0.8145,0.2766,0.847,0.1412,0.071,0.9845,0.338]},{"license":"粤A4097","distribution":[0.0061,0.7626,0.4553,0.9004,0.8695,0.7755,0.2718,0.7408,0.3056,0.6851,0.207,0.2619,0.0511,0.7704,0.5842,0.2446,0.9319,0.7158,0.4052,0.3791,0.1715,0.1239,0.424,0.2876]},{"license":"粤A7377","distribution":[0.652,0.6688,0.9857,0.0592,0.7005,0.9247,0.9239,0.4367,0.1653,0.5022,0.1723,0.1767,0.9809,0.0057,0.1429,0.01,0.7028,0.5021,0.6698,0.8114,0.6574,0.4942,0.4382,0.2817]},{"license":"粤A7996","distribution":[0.7634,0.5325,0.0911,0.5113,0.8895,0.2621,0.0551,0.0264,0.6057,0.9768,0.0603,0.5211,0.4144,0.2666,0.4879,0.6616,0.5412,0.3586,0.6967,0.2268,0.9773,0.1933,0.2707,0.685]},{"license":"粤A7204","distribution":[0.895,0.5632,0.7252,0.8859,0.3049,0.2861,0.1958,0.1405,0.4034,0.707,0.4015,0.3665,0.7357,0.4375,0.4199,0.8295,0.9709,0.122,0.8314,0.2287,0.8214,0.0132,0.6675,0.6802]},{"license":"粤A2810","distribution":[0.366,0.6531,0.9627,0.1782,0.2884,0.9428,0.2081,0.1906,0.1087,0.9947,0.3425,0.0732,0.6434,0.8992,0.6186,0.5899,0.1678,0.9964,0.1081,0.2461,0.878,0.225,0.2009,0.3367]},{"license":"粤A4095","distribution":[0.4535,0.2697,0.911,0.9552,0.9648,0.9526,0.8674,0.6851,0.7738,0.7475,0.9179,0.2896,0.553,0.1349,0.6968,0.3138,0.8521,0.9236,0.3458,0.0284,0.2195,0.1832,0.1908,0.3878]},{"license":"粤A8961","distribution":[0.2359,0.4211,0.4599,0.6673,0.3137,0.178,0.0555,0.3847,0.2633,0.0375,0.6798,0.5502,0.1149,0.5679,0.7106,0.9721,0.3861,0.0681,0.5641,0.398,0.2911,0.2629,0.7738,0.8608]},{"license":"粤A8969","distribution":[0.0543,0.9865,0.684,0.3839,0.4408,0.3508,0.4196,0.5458,0.5299,0.1114,0.382,0.4918,0.8714,0.5443,0.3874,0.8467,0.6933,0.4575,0.3947,0.9293,0.9003,0.8522,0.3863,0.583]},{"license":"粤A5133","distribution":[0.9303,0.1415,0.9856,0.7562,0.5389,0.8638,0.4646,0.8098,0.3325,0.776,0.7371,0.2598,0.1963,0.4203,0.5815,0.0169,0.2469,0.4969,0.2765,0.7946,0.6937,0.5802,0.4568,0.6432]},{"license":"粤A2551","distribution":[0.8089,0.788,0.4606,0.9583,0.4282,0.4637,0.9036,0.4756,0.458,0.6476,0.6334,0.6186,0.271,0.2889,0.3658,0.6863,0.9404,0.604,0.9799,0.1426,0.5728,0.1232,0.2378,0.1123]},{"license":"粤A1000","distribution":[0.991,0.5532,0.1015,0.7895,0.0108,0.5027,0.5984,0.9821,0.8186,0.4578,0.8881,0.6299,0.5836,0.8831,0.9457,0.6053,0.488,0.8132,0.8164,0.4448,0.7456,0.5918,0.8366,0.8156]},{"license":"粤A3491","distribution":[0.5135,0.9799,0.1575,0.4928,0.0245,0.7462,0.2101,0.6154,0.2024,0.7816,0.8127,0.6034,0.7138,0.9626,0.9887,0.8635,0.8791,0.6941,0.4742,0.5609,0.2765,0.6931,0.6964,0.1674]},{"license":"粤A9863","distribution":[0.4157,0.7181,0.0198,0.6451,0.267,0.8594,0.0669,0.0877,0.8267,0.2859,0.575,0.5775,0.2924,0.1541,0.1895,0.1234,0.6774,0.4151,0.1198,0.549,0.047,0.6458,0.9876,0.2577]},{"license":"粤A6145","distribution":[0.696,0.8917,0.1373,0.5967,0.711,0.5943,0.9711,0.1199,0.6634,0.9912,0.7737,0.2331,0.5295,0.8979,0.5411,0.2985,0.8744,0.7294,0.5499,0.6854,0.521,0.2421,0.4168,0.1922]}]}}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * bar : {"title":"异常车辆数量分布","x":[1,2,3,4,5,6,7,8,9,10,11],"y":[382,811,798,955,725,922,46,470,790,460,650]}
         * pies : {"title":"异常车辆概率分布","pie":[{"area":0,"abnormal":0.6483,"normal":0.3517},{"area":1,"abnormal":0.5222,"normal":0.4778},{"area":2,"abnormal":0.4589,"normal":0.5411},{"area":3,"abnormal":0.29,"normal":0.71},{"area":4,"abnormal":0.1998,"normal":0.8002},{"area":5,"abnormal":0.5476,"normal":0.4524},{"area":6,"abnormal":0.4735,"normal":0.5265},{"area":7,"abnormal":0.9199,"normal":0.0801},{"area":8,"abnormal":0.5073,"normal":0.4927},{"area":9,"abnormal":0.5142,"normal":0.4858},{"area":10,"abnormal":0.4033,"normal":0.5967},{"area":11,"abnormal":0.9892,"normal":0.0108}]}
         * cars : {"normal_distribution":[0.06426373,0.3827749,0.8520558,0.37014769,0.42223424,0.56963216,0.63982495,0.70254477,0.20470247,0.06790777,0.99255217,0.73894742,0.65990171,0.57961428,0.07063356,0.59503219,0.89232095,0.88236465,0.78101472,0.7314493,0.31850466,0.062347,0.19801045,0.74821474],"abnormal":[{"license":"粤A5273","distribution":[0.0988,0.3677,0.9573,0.7892,0.8027,0.8155,0.473,0.6067,0.6387,0.7532,0.1587,0.7943,0.2529,0.7567,0.1728,0.5663,0.2777,0.1354,0.2971,0.5901,0.2507,0.172,0.3961,0.5143]},{"license":"粤A4781","distribution":[0.0285,0.6864,0.1494,0.0855,0.303,0.7447,0.4716,0.6145,0.7216,0.0685,0.5296,0.222,0.1677,0.936,0.2552,0.3112,0.2415,0.034,0.4689,0.6398,0.5549,0.7204,0.6617,0.6122]},{"license":"粤A6894","distribution":[0.9983,0.6478,0.2701,0.0341,0.4205,0.2859,0.6579,0.421,0.9703,0.97,0.8515,0.0669,0.4693,0.0061,0.1583,0.8396,0.0679,0.5034,0.6696,0.237,0.6135,0.5293,0.845,0.6835]},{"license":"粤A8069","distribution":[0.8352,0.4846,0.1378,0.9787,0.3448,0.6047,0.5754,0.042,0.9512,0.8873,0.1506,0.2732,0.7128,0.027,0.465,0.8524,0.7375,0.4462,0.8054,0.8291,0.4844,0.3507,0.3021,0.2851]},{"license":"粤A3078","distribution":[0.1293,0.5244,0.9795,0.5215,0.8353,0.825,0.3063,0.289,0.3119,0.6092,0.7448,0.496,0.2136,0.7755,0.2689,0.4788,0.9002,0.6705,0.5385,0.98,0.7109,0.4419,0.8315,0.6198]},{"license":"粤A5621","distribution":[0.1955,0.0381,0.0077,0.3351,0.502,0.5227,0.6222,0.2901,0.1335,0.8176,0.8332,0.7523,0.6883,0.1125,0.9112,0.0665,0.0744,0.8145,0.2766,0.847,0.1412,0.071,0.9845,0.338]},{"license":"粤A4097","distribution":[0.0061,0.7626,0.4553,0.9004,0.8695,0.7755,0.2718,0.7408,0.3056,0.6851,0.207,0.2619,0.0511,0.7704,0.5842,0.2446,0.9319,0.7158,0.4052,0.3791,0.1715,0.1239,0.424,0.2876]},{"license":"粤A7377","distribution":[0.652,0.6688,0.9857,0.0592,0.7005,0.9247,0.9239,0.4367,0.1653,0.5022,0.1723,0.1767,0.9809,0.0057,0.1429,0.01,0.7028,0.5021,0.6698,0.8114,0.6574,0.4942,0.4382,0.2817]},{"license":"粤A7996","distribution":[0.7634,0.5325,0.0911,0.5113,0.8895,0.2621,0.0551,0.0264,0.6057,0.9768,0.0603,0.5211,0.4144,0.2666,0.4879,0.6616,0.5412,0.3586,0.6967,0.2268,0.9773,0.1933,0.2707,0.685]},{"license":"粤A7204","distribution":[0.895,0.5632,0.7252,0.8859,0.3049,0.2861,0.1958,0.1405,0.4034,0.707,0.4015,0.3665,0.7357,0.4375,0.4199,0.8295,0.9709,0.122,0.8314,0.2287,0.8214,0.0132,0.6675,0.6802]},{"license":"粤A2810","distribution":[0.366,0.6531,0.9627,0.1782,0.2884,0.9428,0.2081,0.1906,0.1087,0.9947,0.3425,0.0732,0.6434,0.8992,0.6186,0.5899,0.1678,0.9964,0.1081,0.2461,0.878,0.225,0.2009,0.3367]},{"license":"粤A4095","distribution":[0.4535,0.2697,0.911,0.9552,0.9648,0.9526,0.8674,0.6851,0.7738,0.7475,0.9179,0.2896,0.553,0.1349,0.6968,0.3138,0.8521,0.9236,0.3458,0.0284,0.2195,0.1832,0.1908,0.3878]},{"license":"粤A8961","distribution":[0.2359,0.4211,0.4599,0.6673,0.3137,0.178,0.0555,0.3847,0.2633,0.0375,0.6798,0.5502,0.1149,0.5679,0.7106,0.9721,0.3861,0.0681,0.5641,0.398,0.2911,0.2629,0.7738,0.8608]},{"license":"粤A8969","distribution":[0.0543,0.9865,0.684,0.3839,0.4408,0.3508,0.4196,0.5458,0.5299,0.1114,0.382,0.4918,0.8714,0.5443,0.3874,0.8467,0.6933,0.4575,0.3947,0.9293,0.9003,0.8522,0.3863,0.583]},{"license":"粤A5133","distribution":[0.9303,0.1415,0.9856,0.7562,0.5389,0.8638,0.4646,0.8098,0.3325,0.776,0.7371,0.2598,0.1963,0.4203,0.5815,0.0169,0.2469,0.4969,0.2765,0.7946,0.6937,0.5802,0.4568,0.6432]},{"license":"粤A2551","distribution":[0.8089,0.788,0.4606,0.9583,0.4282,0.4637,0.9036,0.4756,0.458,0.6476,0.6334,0.6186,0.271,0.2889,0.3658,0.6863,0.9404,0.604,0.9799,0.1426,0.5728,0.1232,0.2378,0.1123]},{"license":"粤A1000","distribution":[0.991,0.5532,0.1015,0.7895,0.0108,0.5027,0.5984,0.9821,0.8186,0.4578,0.8881,0.6299,0.5836,0.8831,0.9457,0.6053,0.488,0.8132,0.8164,0.4448,0.7456,0.5918,0.8366,0.8156]},{"license":"粤A3491","distribution":[0.5135,0.9799,0.1575,0.4928,0.0245,0.7462,0.2101,0.6154,0.2024,0.7816,0.8127,0.6034,0.7138,0.9626,0.9887,0.8635,0.8791,0.6941,0.4742,0.5609,0.2765,0.6931,0.6964,0.1674]},{"license":"粤A9863","distribution":[0.4157,0.7181,0.0198,0.6451,0.267,0.8594,0.0669,0.0877,0.8267,0.2859,0.575,0.5775,0.2924,0.1541,0.1895,0.1234,0.6774,0.4151,0.1198,0.549,0.047,0.6458,0.9876,0.2577]},{"license":"粤A6145","distribution":[0.696,0.8917,0.1373,0.5967,0.711,0.5943,0.9711,0.1199,0.6634,0.9912,0.7737,0.2331,0.5295,0.8979,0.5411,0.2985,0.8744,0.7294,0.5499,0.6854,0.521,0.2421,0.4168,0.1922]}]}
         */

        private BarBean bar;
        private PiesBean pies;
        private CarsBean cars;

        public BarBean getBar() {
            return bar;
        }

        public void setBar(BarBean bar) {
            this.bar = bar;
        }

        public PiesBean getPies() {
            return pies;
        }

        public void setPies(PiesBean pies) {
            this.pies = pies;
        }

        public CarsBean getCars() {
            return cars;
        }

        public void setCars(CarsBean cars) {
            this.cars = cars;
        }

        public static class BarBean {
            /**
             * title : 异常车辆数量分布
             * x : [1,2,3,4,5,6,7,8,9,10,11]
             * y : [382,811,798,955,725,922,46,470,790,460,650]
             */

            private String title;
            private List<Integer> x;
            private List<Integer> y;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<Integer> getX() {
                return x;
            }

            public void setX(List<Integer> x) {
                this.x = x;
            }

            public List<Integer> getY() {
                return y;
            }

            public void setY(List<Integer> y) {
                this.y = y;
            }
        }

        public static class PiesBean {
            /**
             * title : 异常车辆概率分布
             * pie : [{"area":0,"abnormal":0.6483,"normal":0.3517},{"area":1,"abnormal":0.5222,"normal":0.4778},{"area":2,"abnormal":0.4589,"normal":0.5411},{"area":3,"abnormal":0.29,"normal":0.71},{"area":4,"abnormal":0.1998,"normal":0.8002},{"area":5,"abnormal":0.5476,"normal":0.4524},{"area":6,"abnormal":0.4735,"normal":0.5265},{"area":7,"abnormal":0.9199,"normal":0.0801},{"area":8,"abnormal":0.5073,"normal":0.4927},{"area":9,"abnormal":0.5142,"normal":0.4858},{"area":10,"abnormal":0.4033,"normal":0.5967},{"area":11,"abnormal":0.9892,"normal":0.0108}]
             */

            private String title;
            private List<PieBean> pie;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<PieBean> getPie() {
                return pie;
            }

            public void setPie(List<PieBean> pie) {
                this.pie = pie;
            }

            public static class PieBean {
                /**
                 * area : 0
                 * abnormal : 0.6483
                 * normal : 0.3517
                 */

                private int area;
                private double abnormal;
                private double normal;

                public int getArea() {
                    return area;
                }

                public void setArea(int area) {
                    this.area = area;
                }

                public double getAbnormal() {
                    return abnormal;
                }

                public void setAbnormal(double abnormal) {
                    this.abnormal = abnormal;
                }

                public double getNormal() {
                    return normal;
                }

                public void setNormal(double normal) {
                    this.normal = normal;
                }
            }
        }

        public static class CarsBean {
            private List<Double> normal_distribution;
            private List<AbnormalBean> abnormal;

            public List<Double> getNormal_distribution() {
                return normal_distribution;
            }

            public void setNormal_distribution(List<Double> normal_distribution) {
                this.normal_distribution = normal_distribution;
            }

            public List<AbnormalBean> getAbnormal() {
                return abnormal;
            }

            public void setAbnormal(List<AbnormalBean> abnormal) {
                this.abnormal = abnormal;
            }

            public static class AbnormalBean {
                /**
                 * license : 粤A5273
                 * distribution : [0.0988,0.3677,0.9573,0.7892,0.8027,0.8155,0.473,0.6067,0.6387,0.7532,0.1587,0.7943,0.2529,0.7567,0.1728,0.5663,0.2777,0.1354,0.2971,0.5901,0.2507,0.172,0.3961,0.5143]
                 */

                private String license;
                private List<Double> distribution;

                public String getLicense() {
                    return license;
                }

                public void setLicense(String license) {
                    this.license = license;
                }

                public List<Double> getDistribution() {
                    return distribution;
                }

                public void setDistribution(List<Double> distribution) {
                    this.distribution = distribution;
                }
            }
        }
    }
}
