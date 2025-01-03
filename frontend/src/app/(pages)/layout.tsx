import PageMenu from "@/components/page/menu";
import PageSearch from "@/components/page/search";

export default function PageLayout({ children }: { children: React.ReactNode }) {
  return (
    <div className="relative flex justify-center items-start w-[1200px] m-auto">
      <div className="sticky top-0 flex mx-4 max-w-[200px]">
        <PageMenu></PageMenu>
      </div>
      <div className="flex w-full max-w-[680px]">
        {children}
      </div>
      <div className="sticky top-0 flex w-full max-w-[320px]">
        <PageSearch />
      </div>
    </div>
  )
}
